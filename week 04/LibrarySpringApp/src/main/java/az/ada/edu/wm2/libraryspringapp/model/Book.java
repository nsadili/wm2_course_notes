package az.ada.edu.wm2.libraryspringapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String id;
    private String title;
    private String description;
    private int year;
    private String author;
}
