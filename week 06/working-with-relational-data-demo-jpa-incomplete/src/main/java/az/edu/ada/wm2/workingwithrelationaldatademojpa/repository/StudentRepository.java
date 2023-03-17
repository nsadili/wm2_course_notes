package az.edu.ada.wm2.workingwithrelationaldatademojpa.repository;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
