package az.edu.ada.wm2.first_spring_boot_app.service;

import az.edu.ada.wm2.first_spring_boot_app.entity.Student;
import az.edu.ada.wm2.first_spring_boot_app.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getById(Integer id) {
        Optional<Student> stud = studentRepository.findById(id);

        if (stud.isPresent())
            return stud.get();

        return new Student("No Student", "Found");
    }

    public Student getStudentByNamesAnd(String firstName, String lastName) {
        Optional<Student> stud = studentRepository.findByFirstNameAndLastName(firstName, lastName);

        if (stud.isPresent())
            return stud.get();

        return new Student("No Student", "Found");
    }

    public List<Student> getStudentByNamesOr(String firstName, String lastName) {
        List<Student> students = (List<Student>) studentRepository.findByFirstNameOrLastName(firstName, lastName);
        return students;
    }

    public List<Student> getStudentList() {
        List<Student> students = (List<Student>) studentRepository.findAll();

//        students.add(new StudentBean("Nuraddin", "Sadili"));
//        students.add(new StudentBean("Emil", "Huseynov"));
//        students.add(new StudentBean("Huseyn", "Jabbarov"));
//        students.add(new StudentBean("Kanan", "Gafarov"));
//        students.add(new StudentBean("Sabrina-Maria", "Sakka"));
//        students.add(new StudentBean("Ilaha", "Behbudova"));

        return students;
    }
}
