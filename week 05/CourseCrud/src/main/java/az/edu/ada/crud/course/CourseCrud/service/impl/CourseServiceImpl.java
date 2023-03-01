package az.edu.ada.crud.course.CourseCrud.service.impl;

import az.edu.ada.crud.course.CourseCrud.model.Course;
import az.edu.ada.crud.course.CourseCrud.repo.CourseRepository;
import az.edu.ada.crud.course.CourseCrud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> list() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course getById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void update(Course course) {
        Optional<Course> result = courseRepository.findById(course.getId());

        Course oldRecord = result.orElseThrow(() -> new RuntimeException("Course not found"));

        oldRecord.setCourseName(course.getCourseName());
        oldRecord.setFaculty(course.getFaculty());

        courseRepository.save(oldRecord);
    }


    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }


}
