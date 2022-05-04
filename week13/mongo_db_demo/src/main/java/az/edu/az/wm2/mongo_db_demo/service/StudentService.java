package az.edu.az.wm2.mongo_db_demo.service;

import az.edu.az.wm2.mongo_db_demo.dto.StudentDto;
import az.edu.az.wm2.mongo_db_demo.dto.StudentSummaryDto;
import az.edu.az.wm2.mongo_db_demo.entity.Student;
import az.edu.az.wm2.mongo_db_demo.mapper.StudentMapper;
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

    public List<StudentSummaryDto> getAllStudents() {
        return StudentMapper.MAPPER.studentListToStudentSummeryDtoList(stdRepo.findAll());
    }


    public List<Student> getAllStudentsWithGradeBetween(Double min, Double max) {
        return stdRepo.findAllWithGradeBetween(min, max);
    }

    public StudentSummaryDto getStudentById(Integer id) {
        Optional<Student> stdOpt = stdRepo.findById(id);
        if (stdOpt.isPresent()) {
            Student std = stdOpt.get();
            return StudentMapper.MAPPER.studentToStudentSummeryDto(std);
        }
        return new StudentSummaryDto();
    }

    public StudentDto save(StudentDto studentDto) {
        studentDto.setId(sequenceGenerator.generateSequence(Student.SEQUENCE_NAME));
        Student stud = StudentMapper.MAPPER.studentDtoToStudent(studentDto);

        Student savedStd = stdRepo.save(stud);
        return StudentMapper.MAPPER.studentToStudentDto(savedStd);
    }

}

