package az.edu.ada.wm2.librarysystemtask.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    private Integer id;
    private String title;
    private String description;
    private String year;
    private String author;

    public Library(String title, String description, String year, String author) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.author = author;

    }

}
