package com.example.demo.repo;

import java.util.Optional;

import com.example.demo.model.Course;

public interface CourseRepository {

    Iterable<Course> list();

    Optional<Course> findById(Integer id);

    Course save(Course course);

    void update(Course course);

    void deleteById(Integer id);
}
