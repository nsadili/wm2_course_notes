package az.edu.ada.wm2.coursecrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Course {

    @Id
    private int id;
    private String course_name;
    private String course_fac;

    public Course(String course_name, String course_fac){
        this.course_name = course_name;
        this.course_fac = course_fac;
    }

}
