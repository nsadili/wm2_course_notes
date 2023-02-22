package az.edu.ada.wm2.bookapp.service;

import az.edu.ada.wm2.bookapp.model.Book;
import java.util.List;

public interface BookService {
    List<Book> listBooks();
    Book getBookById(final Integer bookId);
    void createBook(final Book book);
    void updateBook(final Integer bookId, final Book newBook);
    void deleteBook(final Integer bookId);

}
