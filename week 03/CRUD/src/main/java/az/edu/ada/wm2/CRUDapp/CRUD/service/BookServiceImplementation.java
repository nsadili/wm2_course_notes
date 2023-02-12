package az.edu.ada.wm2.CRUDapp.CRUD.service;


import az.edu.ada.wm2.CRUDapp.CRUD.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImplementation implements BookService {
    static final List<Book> books;

    static {
        books = new ArrayList<>();
        books.add(new Book(UUID.randomUUID().toString(),"A TIME TO KILL","This one is from 3:3 in the Ecclesiastes, again part of the Old Testament.","1862","JOHN GRISHAM"));
        books.add(new Book(UUID.randomUUID().toString(), "THE HOUSE OF MIRTH","The heart of the wise is in the house of mourning; but the heart of fools is in the house of mirth.","1905","EDITH WHARTON"));
        books.add(new Book(UUID.randomUUID().toString(), "EAST OF EDEN","The title is suitably grand. Taken from Genesis, the first book of the Old Testament.","1952","JOHN STEINBECK"));
    }

    @Override
    public List<Book> list() {
        return books;
    }

    @Override
    public Book getById(String id) {
        Optional<Book> result = books.stream().filter(book -> book.getId().equals(id)).findAny();
        return result.orElse(new Book());
    }

    @Override
    public Book save(Book book) {
        if(book.getId() == null) {
            book.setId(UUID.randomUUID().toString());
            books.add(book);

            return book;
        }

        Optional<Book> result = books.stream()
                .filter(p -> p.getId().equals(book.getId()))
                .findAny();

        Book oldRecord = result.orElseThrow();

        oldRecord.setTitle(book.getTitle());
        oldRecord.setDescription(book.getDescription());
        oldRecord.setYear(book.getYear());
        oldRecord.setAuthor(book.getAuthor());

        return oldRecord;
    }

    @Override
    public void deleteById(String id) {
        Optional<Book> result = books.stream()
                .filter(book -> book.getId().equals(id))
                .findAny();

        if (result.isPresent())
            books.remove(result.get());
    }
}
