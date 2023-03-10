package az.edu.ada.wm2.workingwithrelationaldatademojpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name="name")
    private String firstName;
    private String lastName;
    @ManyToMany//(cascade = CascadeType.PERSIST)
            @JoinTable(
                    name = "tbl_student_course",
                    joinColumns = {@JoinColumn(name="stud_id", referencedColumnName = "id")},
                    inverseJoinColumns = @JoinColumn(name="crs_id")
            )
    private Set<Course> courses;

    //initialization blocks
    {
        this.courses = new HashSet<>();
    }

    public void addCourse(Course c){
        this.courses.add(c);
    }
}
