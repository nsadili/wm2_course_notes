package com.example.coursecrud.service;

import com.example.coursecrud.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    void insertCourse(Course course);
    void deleteCourseById(Integer id);
    void updateCourseById(Integer id, Course newVersion);
    Course getCourseById(Integer id);

    void save(Course course);
}
