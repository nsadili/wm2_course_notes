package az.edu.ada.wm2.course.service.impl;

import az.edu.ada.wm2.course.entity.Course;
import az.edu.ada.wm2.course.repo.CourseRepository;
import az.edu.ada.wm2.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
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

        oldRecord.setName(course.getName());
        //.setLastName(course.getLastName());

        // courseRepository.update(oldRecord);
        courseRepository.save(oldRecord);
    }

    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }
}
