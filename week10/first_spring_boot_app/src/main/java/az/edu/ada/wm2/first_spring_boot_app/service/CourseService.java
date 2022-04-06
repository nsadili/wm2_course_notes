package az.edu.ada.wm2.first_spring_boot_app.service;

import az.edu.ada.wm2.first_spring_boot_app.entity.Course;
import az.edu.ada.wm2.first_spring_boot_app.entity.Student;
import az.edu.ada.wm2.first_spring_boot_app.repo.CourseRepository;
import az.edu.ada.wm2.first_spring_boot_app.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourseList() {
        List<Course> courses = (List<Course>) courseRepository.findAll();

        return courses;
    }

    public List<Course> getAllWebCourses() {
        return (List<Course>) courseRepository.getAllWebCourses();
    }
}
