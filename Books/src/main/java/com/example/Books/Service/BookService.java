package com.example.Books.Service;

import com.example.Books.Model.Book;
import com.example.Books.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private final BookRepository bookRepository;
    public List<Book> getList(){

        return (List<Book>) bookRepository.findAll();
    }
    public Book delete(Integer id) {
        bookRepository.deleteById(id);

        Optional<Book> inter = bookRepository.findById(id);

        Book book = inter.orElseGet(() -> new Book(null, "Book", "doesn't", "exist"));
        return book;

    }
    public boolean exist(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.isPresent();
    }
    public Book saveBook (Book book){
return bookRepository.save(book);
    }

}
