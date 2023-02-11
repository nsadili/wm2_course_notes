package az.edu.ada.wm2.myfirstspringapp.service;

import az.edu.ada.wm2.myfirstspringapp.model.BookModel;

import java.util.List;

public interface BookService {
    List<BookModel> listBooks();
    BookModel getBook(final String bookId);
    void createBook(final BookModel book);
    void editBook(final String bookId, final BookModel newBook);
    void deleteBook(final String bookId);

}
