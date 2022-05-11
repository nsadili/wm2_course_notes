package az.edu.ada.wm2.testing.service;

import az.edu.ada.wm2.testing.entity.Student;
import az.edu.ada.wm2.testing.repo.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository stdRepo;

    public List<Student> getStudents() {
        return (List<Student>) stdRepo.findAll();
    }

    public Student getStudent(Long id) {
        Optional<Student> res = stdRepo.findById(id);
        if (res.isPresent()) return res.get();

        return new Student();
    }

    public Student save(Student std){
        return stdRepo.save(std);
    }
}
