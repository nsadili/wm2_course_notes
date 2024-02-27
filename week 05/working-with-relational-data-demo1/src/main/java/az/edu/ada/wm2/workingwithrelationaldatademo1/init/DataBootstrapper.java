package az.edu.ada.wm2.workingwithrelationaldatademo1.init;

import az.edu.ada.wm2.workingwithrelationaldatademo1.model.Person;
import az.edu.ada.wm2.workingwithrelationaldatademo1.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DataBootstrapper implements CommandLineRunner {

    @Autowired
    PersonRepository personRepo;

    public void run(String... args) throws Exception {
        personRepo.save(new Person("Sadig", "Mehdiyev"));
    }
}
