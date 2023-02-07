package az.edu.ada.wm2.lmsapp.repository;

import az.edu.ada.wm2.lmsapp.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends
        CrudRepository<Student, Integer>,
        PagingAndSortingRepository<Student, Integer> {
}
