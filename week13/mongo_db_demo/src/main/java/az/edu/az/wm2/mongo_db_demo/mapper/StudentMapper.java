package az.edu.az.wm2.mongo_db_demo.mapper;

import az.edu.az.wm2.mongo_db_demo.dto.StudentSummaryDto;
import az.edu.az.wm2.mongo_db_demo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface StudentMapper {

    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentSummaryDto studentToStudentSummeryDto(Student std);
}
