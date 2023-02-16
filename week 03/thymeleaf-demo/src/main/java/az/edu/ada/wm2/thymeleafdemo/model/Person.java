package az.edu.ada.wm2.thymeleafdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String id;
    private String firstName;
    private String lastName;
}
