package az.ada.edu.wm2.libraryspringapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    List<Book> books;

    public void addBook(Book book) {

        book.setId(UUID.randomUUID().toString());

        if (CollectionUtils.isEmpty(books)) {
            books = new ArrayList<>();
        }

        books.add(book);
    }
}