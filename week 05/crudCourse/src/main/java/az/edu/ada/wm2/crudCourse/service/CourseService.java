package az.edu.ada.wm2.crudCourse.service;

import az.edu.ada.wm2.crudCourse.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> list();
    Course getById(Integer id);
    Course save(Course course);
    void update(Course course);
    void deleteById(Integer id);

}
