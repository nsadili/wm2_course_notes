package az.edu.ada.wm2.bookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Book {
    @Id
    private Integer id;
    private String title;
    private String description;
    private int year;
    private String author;

    public Book(
            @NonNull final String title,
            final String description,
            @NonNull final int year,
            @NonNull final String author) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.author = author;
    }
}
