package az.edu.ada.wm2.lmsapp.service;

import az.edu.ada.wm2.lmsapp.entity.Student;
import az.edu.ada.wm2.lmsapp.repository.StudentRepository;
import az.edu.ada.wm2.lmsapp.service.utils.PagedAndSortedGetAll;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final PagedAndSortedGetAll<Student, Integer> pagedAndSortedGetAll;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.pagedAndSortedGetAll = new PagedAndSortedGetAll<>(studentRepository, 10);
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Page<Student> getAllStudents(int page) {
        return pagedAndSortedGetAll.getAll(page);
    }

    public Page<Student> getAllStudents(int page, int pageSize) {
        return pagedAndSortedGetAll.getAll(page, pageSize);
    }

    public Page<Student> getAllStudents(int page, int pageSize, String sortBy) {
        return pagedAndSortedGetAll.getAll(page, pageSize, sortBy);
    }

    public Student getById(Integer id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student) {
        Student oldStudent = studentRepository.findById(id).orElseThrow();

        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        oldStudent.setMajor(student.getMajor());
        oldStudent.setApplicationYear(student.getApplicationYear());

        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
