package az.edu.ada.wm2.librarysystemtask.service;


import az.edu.ada.wm2.librarysystemtask.model.Library;

import java.util.List;

public interface LibraryService {
    List<Library> list();

    Library getById(String id);

    Library save(Library library);

    void deleteById(String id);
}