package az.edu.ada.wm2.librarysystemtask.service.impl;

import az.edu.ada.wm2.librarysystemtask.model.Library;
import az.edu.ada.wm2.librarysystemtask.repo.LibraryRepository;
import az.edu.ada.wm2.librarysystemtask.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepository libraryRepo;

    @Override
    public List<Library> list() {
        return (List<Library>) libraryRepo.list();
    }

    @Override
    public Library getById(Integer id) {
        return libraryRepo.findById(id).orElse(null);
    }

    @Override
    public Library save(Library library) {
        return libraryRepo.save(library);
    }

    @Override
    public void update(Library library) {
        Optional<Library> result = libraryRepo.findById(library.getId());

        Library oldRecord = result.orElseThrow(() -> new RuntimeException("Person not found"));

        oldRecord.setTitle(library.getTitle());
        oldRecord.setDescription(library.getDescription());
        oldRecord.setYearr(library.getYearr());
        oldRecord.setAuthor(library.getAuthor());

        libraryRepo.update(oldRecord);
    }


    @Override
    public void deleteById(Integer id) {
        libraryRepo.deleteById(id);
    }


}
