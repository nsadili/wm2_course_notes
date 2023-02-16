package com.example.libapp.view;


import com.example.libapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookServiceInter {
    public static List<Book> books = new ArrayList<>();
    static {
        books.add(new Book(1,"007","James Bond"));
        books.add(new Book(2,"Neighbors in Paris","Barrack Obama"));
        books.add(new Book(3,"Green Mile","Stephen Steve"));
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(long id) {
        for(Book book:books) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void save(Book newBook) {
        for(Book book : books) {
            if(book.getId() == newBook.getId()) {
                book.setTitle(newBook.getTitle());
                book.setAuthor(newBook.getAuthor());
                return;
            }
        }
        books.add(new Book(books.size()+1, newBook.getTitle(), newBook.getAuthor()));
    }

    @Override
    public void remove(long id) {
        for(Book book : books) {
            if(book.getId() == id) {
                books.remove(book);
                return;
            }
        }
    }
}
