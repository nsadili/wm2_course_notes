package com.example.coursecrud.init;

import com.example.coursecrud.model.Course;
import com.example.coursecrud.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CourseBootstrapper implements CommandLineRunner {
    @Autowired
    public CourseRepository courseRepo;

    public void run(String[] args) {
        courseRepo.save(new Course(1, "WM2", "SITE", 6));
    }
}

