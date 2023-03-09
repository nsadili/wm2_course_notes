package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;

public interface CourseService {
    List<Course> list();

    Course getById(Integer id);

    Course save(Course course);

    void update(Course course);

    void deleteById(Integer id);
}

