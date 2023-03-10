package az.edu.ada.wm2.workingwithrelationaldatademojpa.service;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.StudentRepository;

import java.util.List;

public interface StudentService {
    StudentRepository studRepo;
    List<Student> list();

    Student save(Student student);

    Student getById(Long id);

    void deleteById(Long id);

    List<Student> getByFirstAndLastName(String firstName, String lastName){
        return studRepo.findByFirstNameAndLastName(firstName, lastName);
    }
}
