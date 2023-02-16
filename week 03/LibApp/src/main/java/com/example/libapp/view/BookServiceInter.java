package com.example.libapp.view;

import com.example.libapp.model.Book;

import java.util.List;

public interface BookServiceInter {
    List<Book> getAllBooks();
    Book getBookById(long id);
    void save(Book book);
    void remove(long id);
}
