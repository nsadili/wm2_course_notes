package com.example.Crud.App.model;

public class Book {
    private Long id;
    private String title;
    private String author;
    private int year;
    private String description;

    // Default constructor
    public Book() {}

    // Constructor with arguments
    public Book(String title, String author, int year, String description) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

