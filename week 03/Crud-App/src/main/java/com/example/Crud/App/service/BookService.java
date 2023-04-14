package com.example.Crud.App.service;

import com.example.Crud.App.model.Book;
import org.springframework.stereotype.Service;

    import java.util.List;

    public interface BookService {
        List<Book> list();

        Book getById(String id);

        Book save(Book book);

        void deleteById(String id);
    }




