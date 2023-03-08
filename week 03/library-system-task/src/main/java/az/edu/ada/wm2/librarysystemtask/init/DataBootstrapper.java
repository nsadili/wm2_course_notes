package az.edu.ada.wm2.librarysystemtask.init;

import az.edu.ada.wm2.librarysystemtask.model.Library;
import az.edu.ada.wm2.librarysystemtask.repo.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//@Configuration
public class DataBootstrapper implements CommandLineRunner {

    @Autowired

    LibraryRepository libraryRepo;

    public void run(String... args) throws Exception {
        libraryRepo.save(new Library("Sadig", "Mehdiyev","jhg","hg"));
    }
}
