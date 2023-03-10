package az.edu.ada.wm2.workingwithrelationaldatademojpa.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.StudentRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo){
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> list() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

}
