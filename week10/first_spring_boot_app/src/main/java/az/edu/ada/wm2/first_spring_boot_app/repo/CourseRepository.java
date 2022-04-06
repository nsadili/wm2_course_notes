package az.edu.ada.wm2.first_spring_boot_app.repo;

import az.edu.ada.wm2.first_spring_boot_app.entity.Course;
import az.edu.ada.wm2.first_spring_boot_app.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    @Query("select c from Course c where c.courseName like '%Web%'")
    Iterable<Course> getAllWebCourses();

//    @Query(value = "select * from courses where c_name like '%Web%'", nativeQuery = true)
//    Iterable<Course> getAllWebCourses();

}
