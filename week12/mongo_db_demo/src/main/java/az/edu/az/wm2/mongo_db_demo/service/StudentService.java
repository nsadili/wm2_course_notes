package az.edu.az.wm2.mongo_db_demo.service;

import az.edu.az.wm2.mongo_db_demo.entity.Student;
import az.edu.az.wm2.mongo_db_demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository stdRepo;

    public List<Student> getAllStudents() {
        return stdRepo.findAll();
    }


    public List<Student> getAllStudentsWithGradeBetween(Double min, Double max) {
        return stdRepo.findAllWithGradeBetween(min, max);
    }

}

