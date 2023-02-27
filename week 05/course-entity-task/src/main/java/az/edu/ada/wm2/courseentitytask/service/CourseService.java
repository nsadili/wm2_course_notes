package az.edu.ada.wm2.courseentitytask.service;

import az.edu.ada.wm2.courseentitytask.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> list();

    Course getById(String id);

    Course save(Course course);

    void deleteById(String id);

}
