package az.edu.ada.wm2.thymeleafdemo.service;

import az.edu.ada.wm2.thymeleafdemo.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    static final List<Person> persons;

    static {
        persons = new ArrayList<>();
        persons.add(new Person(UUID.randomUUID().toString(), "Nuraddin", "Sadili"));
        persons.add(new Person(UUID.randomUUID().toString(), "Ali", "Mammadov"));
        persons.add(new Person(UUID.randomUUID().toString(), "Jamal", "Ismayil"));
    }

    @Override
    public List<Person> list() {
        return persons;
    }

    @Override
    public Person getById(String id) {
        Optional<Person> result = persons.stream()
                .filter(person -> person.getId().equals(id))
                .findAny();
        return result.orElse(new Person());
    }

    @Override
    public Person save(Person person) {
        if (person.getId() == null) {
            person.setId(UUID.randomUUID().toString());
            persons.add(person);

            return person;
        }


        Optional<Person> result = persons.stream()
                .filter(p -> p.getId().equals(person.getId()))
                .findAny();

        Person oldRecord = result.orElseThrow();

        oldRecord.setFirstName(person.getFirstName());
        oldRecord.setLastName(person.getLastName());


        return oldRecord;
    }

    @Override
    public void deleteById(String id) {
        Optional<Person> result = persons.stream()
                .filter(person -> person.getId().equals(id))
                .findAny();

        result.ifPresent(persons::remove);
    }
}
