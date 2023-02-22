package az.edu.ada.wm2.librarysystemtask.service;


import az.edu.ada.wm2.librarysystemtask.model.Library;

import java.util.List;

public interface LibraryService {
    List<Library> list();

    Library getById(Integer id);

    Library save(Library library);
    void update(Library library);

    void deleteById(Integer id);
}