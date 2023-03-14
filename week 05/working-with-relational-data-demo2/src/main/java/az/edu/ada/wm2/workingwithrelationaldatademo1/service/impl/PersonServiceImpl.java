package az.edu.ada.wm2.workingwithrelationaldatademo1.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademo1.model.Person;
import az.edu.ada.wm2.workingwithrelationaldatademo1.repo.PersonRepository;
import az.edu.ada.wm2.workingwithrelationaldatademo1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepo;

    @Override
    public List<Person> list() {
        return (List<Person>) personRepo.findAll();
    }

    @Override
    public Person getById(Integer id) {
        return personRepo.findById(id).orElse(null);
    }

    @Override
    public Person save(Person person) {
        return personRepo.save(person);
    }

    @Override
    public void update(Person person) {
        Optional<Person> result = personRepo.findById(person.getId());

        Person oldRecord = result.orElseThrow(() -> new RuntimeException("Person not found"));

        oldRecord.setFirstName(person.getFirstName());
        oldRecord.setLastName(person.getLastName());

        personRepo.save(oldRecord);
    }


    @Override
    public void deleteById(Integer id) {
        personRepo.deleteById(id);
    }


}
