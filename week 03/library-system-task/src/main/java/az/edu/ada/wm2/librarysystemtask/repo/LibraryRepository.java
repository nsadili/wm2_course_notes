package az.edu.ada.wm2.librarysystemtask.repo;

import az.edu.ada.wm2.librarysystemtask.model.Library;

import java.util.Optional;

public interface LibraryRepository {

    Iterable<Library> list();

    Optional<Library> findById(Integer id);

    Library save(Library library);

    void update(Library library);

    void deleteById(Integer id);
}
