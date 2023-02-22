package az.edu.ada.wm2.bookapp.repo;

import az.edu.ada.wm2.bookapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {}
