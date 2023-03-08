package az.edu.ada.wm2.librarysystemtask.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class Library {
    private Integer Id;
    private String title;
    private String description;
    private String yearr;
    private String author;

    public Library(String title, String description, String yearr, String author) {
        this.title = title;
        this.description = description;
        this.yearr = yearr;
        this.author = author;

    }

}
