package az.edu.ada.wm2.workingwithrelationaldatademojpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @ManyToMany
    @JoinTable(
            name="tbl_students_courses",
            joinColumns = @JoinColumn(name = "stud_id", referencedColumnName = "id"),
            inverseJoinColumns = {@JoinColumn(name = "crs_id")}
    )
    private Set<Course> courses;

}
