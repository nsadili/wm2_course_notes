package az.edu.ada.crud.course.CourseCrud.init;

import az.edu.ada.crud.course.CourseCrud.model.Course;
import az.edu.ada.crud.course.CourseCrud.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBootstrapper implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepository;

    public void run(String... args) throws Exception {
        courseRepository.save(new Course("WebAndApplicationII", "SITE"));
    }
}
