package az.edu.ada.wm2.workingwithrelationaldatademojpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn( name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = {@JoinColumn (name = "course_id")}

    )
    private Set<Course> courses;
}
