package az.edu.ada.wm2.myfirstspringapp.service;

import az.edu.ada.wm2.myfirstspringapp.model.BookModel;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import org.springframework.http.HttpStatus;

@Service
public class FakeBookService implements BookService{

    private static List<BookModel> books = new ArrayList<>();

    static {
        books.add(new BookModel("1984", "...", 1947, "Orwell"));
        books.add(new BookModel("Fluent Python", "...", 2014, "..."));
    }

    public List<BookModel> listBooks() {
        return books;
    }

    public BookModel getBook(final String bookId) {
        Optional<BookModel> book = books.stream().filter(item->Objects.equals(item.getId(), bookId)).findAny();

        if (book.isPresent()) {
            return book.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
    }

    public void createBook(final BookModel book) {
        books.add(book);
    }

    public void editBook(final String bookId, final BookModel newBook) {
        final int index = books.indexOf(getBook(bookId));
        books.set(index, newBook);
    }

    public void deleteBook(final String bookId) {
        books.remove(getBook(bookId));
    }
}
