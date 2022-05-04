package az.edu.az.wm2.mongo_db_demo.mapper;

import az.edu.az.wm2.mongo_db_demo.dto.StudentDto;
import az.edu.az.wm2.mongo_db_demo.dto.StudentSummaryDto;
import az.edu.az.wm2.mongo_db_demo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "grade", target = "gpa")
    StudentSummaryDto studentToStudentSummeryDto(Student std);

    List<StudentSummaryDto> studentListToStudentSummeryDtoList(List<Student> students);

    @Mapping(source = "grade", target = "gpa")
    StudentDto studentToStudentDto(Student std);

    @Mapping(target = "grade", source = "gpa")
    Student studentDtoToStudent(StudentDto stdDto);
}
