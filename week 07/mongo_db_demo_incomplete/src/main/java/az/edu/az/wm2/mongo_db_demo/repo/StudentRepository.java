package az.edu.az.wm2.mongo_db_demo.repo;

import az.edu.az.wm2.mongo_db_demo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {
}
