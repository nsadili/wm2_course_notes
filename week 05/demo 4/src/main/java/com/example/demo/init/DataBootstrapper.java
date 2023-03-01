package com.example.demo.init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Course;
import com.example.demo.repo.CourseRepository;

//@Configuration
public class DataBootstrapper implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepo;

    public void run(String... args) throws Exception {
        courseRepo.save(new Course("PP1", "Site", 6));
    }
}

