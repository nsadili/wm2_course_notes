package az.edu.ada.wm2.workingwithrelationaldatademojpa.service;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> list();

    Student save(Student course);

    Student getById(Long id);

    void deleteById(Long id);

}
