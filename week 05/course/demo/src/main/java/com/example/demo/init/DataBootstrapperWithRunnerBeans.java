package com.example.demo.init;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Course;
import com.example.demo.repo.CourseRepository;

@Configuration
public class DataBootstrapperWithRunnerBeans {

    @Bean
    public CommandLineRunner dataBootstrapperWithCommandLineRunner(CourseRepository courseRepo) {
        return args -> {
            courseRepo.save(new Course("PP1", "Site", 6));
        };
    }
}