package az.edu.ada.wm2.workingwithrelationaldatademo1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Integer id;
    private String firstName;
    private String lastName;
//    private float GPA;

    public Person(String firstName, String lastName) // float GPA
    {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.GPA = GPA;
    }
}
