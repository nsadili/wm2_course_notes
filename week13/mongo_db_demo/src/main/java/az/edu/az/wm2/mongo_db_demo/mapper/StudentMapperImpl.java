package az.edu.az.wm2.mongo_db_demo.mapper;

import az.edu.az.wm2.mongo_db_demo.dto.StudentSummaryDto;
import az.edu.az.wm2.mongo_db_demo.entity.Student;

public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentSummaryDto studentToStudentSummeryDto(Student std) {

        if (std == null) return null;

        StudentSummaryDto stdDto = new StudentSummaryDto();

        stdDto.setId(std.getId());
        stdDto.setFirstname(std.getFirstname());
        stdDto.setGpa(std.getGrade());

        return stdDto;
    }
}
