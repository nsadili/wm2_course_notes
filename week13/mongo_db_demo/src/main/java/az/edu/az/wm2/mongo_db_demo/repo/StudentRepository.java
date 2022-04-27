package az.edu.az.wm2.mongo_db_demo.repo;


import az.edu.az.wm2.mongo_db_demo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, Integer> {

    @Query("{ 'grade' : { $gt: ?0, $lt: ?1 } }")
    List<Student> findAllWithGradeBetween(Double min, Double max);

}
