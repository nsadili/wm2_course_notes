package az.edu.ada.wm2.CRUDapp.CRUD.service;

import az.edu.ada.wm2.CRUDapp.CRUD.model.Book;

import java.util.List;

public interface BookService {
    List<Book> list();

    Book getById(String id);

    Book save(Book book);

    void deleteById(String id);
}
