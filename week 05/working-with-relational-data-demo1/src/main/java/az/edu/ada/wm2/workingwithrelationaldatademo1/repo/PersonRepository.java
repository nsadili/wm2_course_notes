package az.edu.ada.wm2.workingwithrelationaldatademo1.repo;

import az.edu.ada.wm2.workingwithrelationaldatademo1.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PersonRepository {

    Iterable<Person> list();

    Optional<Person> findById(Integer id);

    Person save(Person person);

    void update(Person person);

    void deleteById(Integer id);
}
