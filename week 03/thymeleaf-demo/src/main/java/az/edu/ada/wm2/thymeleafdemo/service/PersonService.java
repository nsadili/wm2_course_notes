package az.edu.ada.wm2.thymeleafdemo.service;

import az.edu.ada.wm2.thymeleafdemo.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> list();

    Person getById(String id);

    Person save(Person person);

    void deleteById(String id);
}
