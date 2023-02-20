package az.edu.ada.wm2.workingwithrelationaldatademo1.repo;

import az.edu.ada.wm2.workingwithrelationaldatademo1.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

//public interface PersonRepository extends Repository<Person, Integer> {
//
//    Iterable<Person> findAll();
//
//    Optional<Person> findById(Integer id);
//
//    Person save(Person person);
//
//    void deleteById(Integer id);
//}

public interface PersonRepository extends CrudRepository<Person, Integer> {

}