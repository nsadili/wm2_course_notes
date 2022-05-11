package az.edu.ada.wm2.testing.repo;

import az.edu.ada.wm2.testing.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
