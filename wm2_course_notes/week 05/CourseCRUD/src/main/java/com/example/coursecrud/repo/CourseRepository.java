package com.example.coursecrud.repo;

import com.example.coursecrud.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
