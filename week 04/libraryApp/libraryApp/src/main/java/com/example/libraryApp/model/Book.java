package com.example.libraryApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    String book;
    List<String> books;

    public void addProduct(String book) {
        if (CollectionUtils.isEmpty(books)) {
            books = new ArrayList<>();
        }
        books.add(book);
    }
}
