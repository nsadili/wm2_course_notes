package com.example.coursecrud.service;

import com.example.coursecrud.model.Course;
import com.example.coursecrud.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepo;

    @Override
    public List<Course> getAll() {
        return (List<Course>) courseRepo.findAll();
    }

    @Override
    public void insertCourse(Course course) {
        courseRepo.save(course);
    }

    @Override
    public void deleteCourseById(Integer id) {
        courseRepo.deleteById(id);
    }

    @Override
    public void updateCourseById(Integer id, Course newVersion) {
        courseRepo.deleteById(id);
        courseRepo.save(new Course(id, newVersion.getName(), newVersion.getDepartmentName(), newVersion.getCredits()));
    }

    @Override
    public Course getCourseById(Integer id) {
        for(Course c : getAll()) {
            if(c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void save(Course course) {
        for(Course c : getAll()) {
            if(c.getId() == course.getId()) {
                updateCourseById(course.getId(), course);
                return;
            }
        }
        insertCourse(course);
    }
}
