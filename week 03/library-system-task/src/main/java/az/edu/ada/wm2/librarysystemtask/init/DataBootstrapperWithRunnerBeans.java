package az.edu.ada.wm2.librarysystemtask.init;

import az.edu.ada.wm2.librarysystemtask.model.Library;
import az.edu.ada.wm2.librarysystemtask.repo.LibraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBootstrapperWithRunnerBeans {

    @Bean
    public CommandLineRunner dataBootstrapperWithCommandLineRunner(LibraryRepository libraryRepo) {
        return args -> {
            libraryRepo.save(new Library("Sadig", "Mehdiyev","kjh","iu"));
        };
    }

//    @Bean
//    public ApplicationRunner dataBootstrapperWithApplicationRunner(PersonRepository personRepo) {
//        return args -> {
//            personRepo.save(new Person("Sadig", "Mehdiyev"));
//        };
//    }

}