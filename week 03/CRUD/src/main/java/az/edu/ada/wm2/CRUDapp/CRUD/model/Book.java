package az.edu.ada.wm2.CRUDapp.CRUD.model;

public class Book {
    private String id;

    private String title;

    private String description;

    private String year;

    private String author;

    public Book(){

    }

    public Book(String id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Book(String id, String title, String description, String year){
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
    }

    public Book(String id, String title, String description, String year, String author){
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
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
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", year='" + year + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
