package az.edu.ada.wm2.workingwithrelationaldatademo1.init;

import az.edu.ada.wm2.workingwithrelationaldatademo1.model.Person;
import az.edu.ada.wm2.workingwithrelationaldatademo1.repo.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBootstrapperWithRunnerBeans {

    @Bean
    public CommandLineRunner dataBootstrapperWithCommandLineRunner(PersonRepository personRepo) {
        return args -> {
            personRepo.save(new Person("Sadig", "Mehdiyev"));
        };
    }

//    @Bean
//    public ApplicationRunner dataBootstrapperWithApplicationRunner(PersonRepository personRepo) {
//        return args -> {
//            personRepo.save(new Person("Sadig", "Mehdiyev"));
//        };
//    }

}
