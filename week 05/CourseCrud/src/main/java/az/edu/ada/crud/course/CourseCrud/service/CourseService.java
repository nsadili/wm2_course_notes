package az.edu.ada.crud.course.CourseCrud.service;

import az.edu.ada.crud.course.CourseCrud.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> list();

    Course getById(Integer id);

    Course save(Course course);

    void update(Course course);

    void deleteById(Integer id);
}
