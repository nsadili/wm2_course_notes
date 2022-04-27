package az.edu.az.wm2.mongo_db_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSummaryDto {

    private Long id;
    private String firstname;
    private Double gpa;
}
