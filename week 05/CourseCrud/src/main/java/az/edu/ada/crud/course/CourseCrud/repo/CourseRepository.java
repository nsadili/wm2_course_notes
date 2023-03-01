package az.edu.ada.crud.course.CourseCrud.repo;

import az.edu.ada.crud.course.CourseCrud.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}