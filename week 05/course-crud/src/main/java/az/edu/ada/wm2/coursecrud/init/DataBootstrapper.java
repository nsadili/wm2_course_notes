package az.edu.ada.wm2.coursecrud.init;

import az.edu.ada.wm2.coursecrud.model.Course;
import az.edu.ada.wm2.coursecrud.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBootstrapper implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepo;

    public void run(String... args) throws Exception{
        courseRepo.save(new Course("Calculus 2","SITE"));
    }
}
