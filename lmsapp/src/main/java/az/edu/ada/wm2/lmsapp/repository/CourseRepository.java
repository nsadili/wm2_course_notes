package az.edu.ada.wm2.lmsapp.repository;

import az.edu.ada.wm2.lmsapp.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends
        CrudRepository<Course, Integer>,
        PagingAndSortingRepository<Course, Integer> {
}
