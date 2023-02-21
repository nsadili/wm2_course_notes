package az.edu.ada.wm2.workingwithrelationaldatademo1.service;


import az.edu.ada.wm2.workingwithrelationaldatademo1.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> list();

    Person getById(Integer id);

    Person save(Person person);

    void update(Person person);

    void deleteById(Integer id);
}
