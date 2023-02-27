package az.edu.ada.wm2.courseentitytask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private String id;
    private String name;
    private String departmentname;
    private String credits;



}
