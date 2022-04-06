package az.edu.ada.wm2.first_spring_boot_app.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "STUDENT_LIST")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @Column(name = "school")
    private String schoolName;

    @ManyToMany
    @JoinTable(
            name = "STUDENT_ENROLLMENTS",
            joinColumns = @JoinColumn(name = "stud_id"),
            inverseJoinColumns = @JoinColumn(name = "crs_id")
    )
    private Set<Course> courses;

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
