package az.edu.ada.wm2.workingwithrelationaldatademojpa.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.StudentRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studRepo;

    public StudentServiceImpl(StudentRepository studRepo) {
        this.studRepo = studRepo;
    }

    @Override
    public List<Student> list() {
        return studRepo.findAll();
    }

    @Override
    public Student save(Student student) {
        return studRepo.save(student);
    }

    @Override
    public Student getById(Long id) {
        return studRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        studRepo.deleteById(id);
    }
}
