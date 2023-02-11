package az.edu.ada.wm2.myfirstspringapp.model;

import java.util.UUID;

public class BookModel {
    private String id;
    private String title;
    private String description;
    private int year;
    private String author;

    public BookModel(final String id,
                     final String title,
                     final String description,
                     final int year,
                     final String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.author = author;
    }

    public BookModel(
            final String title,
            final String description,
            final int year,
            final String author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.year = year;
        this.author = author;
    }

    public BookModel() {
        this.id = UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                '}';
    }
}
