package az.edu.ada.wm2.librarysystemtask.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    private String id;
    private String title;
    private String description;
    private String year;
    private String author;



}
