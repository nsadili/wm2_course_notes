package az.edu.az.wm2.mongo_db_demo.repo;

import az.edu.az.wm2.mongo_db_demo.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
