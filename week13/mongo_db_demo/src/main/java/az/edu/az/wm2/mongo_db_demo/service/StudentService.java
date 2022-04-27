package az.edu.az.wm2.mongo_db_demo.service;

import az.edu.az.wm2.mongo_db_demo.entity.Student;
import az.edu.az.wm2.mongo_db_demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository stdRepo;

    @Autowired
    StudentSequenceGenerator sequenceGenerator;

    public List<Student> getAllStudents() {
        return stdRepo.findAll();
    }


    public List<Student> getAllStudentsWithGradeBetween(Double min, Double max) {
        return stdRepo.findAllWithGradeBetween(min, max);
    }

    public Student getStudentById(Integer id) {
        Optional<Student> stdOpt = stdRepo.findById(id);
        if (stdOpt.isPresent()) {
            return stdOpt.get();
        }
        return new Student();
    }

    public Student save(Student student) {
        student.setId(sequenceGenerator.generateSequence(Student.SEQUENCE_NAME));
        return stdRepo.save(student);
    }

}

