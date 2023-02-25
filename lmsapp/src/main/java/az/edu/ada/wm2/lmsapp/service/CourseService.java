package az.edu.ada.wm2.lmsapp.service;

import az.edu.ada.wm2.lmsapp.entity.Course;
import az.edu.ada.wm2.lmsapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> listCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course getById(Integer id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course) {
        Course oldCourse = courseRepository.findById(id).orElseThrow();

        oldCourse.setName(course.getName());
        oldCourse.setDepartmentName(course.getDepartmentName());
        oldCourse.setCredits(course.getCredits());

        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
