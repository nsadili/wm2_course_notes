package az.edu.ada.wm2.coursecrud.service;

import az.edu.ada.wm2.coursecrud.model.Course;

import java.util.List;
public interface CourseService {

    List<Course> list();

    Course save(Course course);

    void update(Course course);

    void deleteById(Integer id);

    Course getById(Integer id);
}
