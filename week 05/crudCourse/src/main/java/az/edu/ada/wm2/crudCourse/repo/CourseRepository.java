package az.edu.ada.wm2.crudCourse.repo;

import az.edu.ada.wm2.crudCourse.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

}
