package az.edu.ada.wm2.bookapp.init;

import az.edu.ada.wm2.bookapp.model.Book;
import az.edu.ada.wm2.bookapp.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBootstrapper implements CommandLineRunner {
    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.save(new Book("Fluent Python", null, 2015, "Luciano Ramalho"));
    }
}
