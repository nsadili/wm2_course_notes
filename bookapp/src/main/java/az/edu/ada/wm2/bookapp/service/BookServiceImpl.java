package az.edu.ada.wm2.bookapp.service;

import az.edu.ada.wm2.bookapp.exception.BookNotFound;
import az.edu.ada.wm2.bookapp.model.Book;
import az.edu.ada.wm2.bookapp.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> listBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book getBookById(final Integer bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public void createBook(final Book book) {
        bookRepository.save(book);
    }

    public void updateBook(final Integer bookId, final Book newBook) {
        Optional<Book> result = bookRepository.findById(bookId);
        Book oldRecord = result.orElseThrow(BookNotFound::new);

        oldRecord.setTitle(newBook.getTitle());
        oldRecord.setDescription(newBook.getDescription());
        oldRecord.setYear(newBook.getYear());
        oldRecord.setAuthor(newBook.getAuthor());

        bookRepository.save(oldRecord);
    }

    public void deleteBook(final Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
