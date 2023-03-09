package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.repo.CourseRepository;
import com.example.demo.service.CourseService;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepo;

    @Override
    public List<Course> list() {
        return (List<Course>) courseRepo.list();
    }

    @Override
    public Course getById(Integer id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public Course save(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void update(Course course) {
        Optional<Course> result = courseRepo.findById(course.getId());

        Course oldRecord = result.orElseThrow(() -> new RuntimeException("Course not found"));

        oldRecord.setCourseName(course.getCourseName());
        oldRecord.setDepartmentName(course.getDepartmentName());
        oldRecord.setCredits(course.getCredits());

        courseRepo.update(oldRecord);
    }


    @Override
    public void deleteById(Integer id) {
        courseRepo.deleteById(id);
    }


}
