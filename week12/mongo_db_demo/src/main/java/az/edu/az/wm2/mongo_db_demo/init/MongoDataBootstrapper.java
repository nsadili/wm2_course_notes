package az.edu.az.wm2.mongo_db_demo.init;

import az.edu.az.wm2.mongo_db_demo.entity.Course;
import az.edu.az.wm2.mongo_db_demo.entity.Student;
import az.edu.az.wm2.mongo_db_demo.repo.CourseRepository;
import az.edu.az.wm2.mongo_db_demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MongoDataBootstrapper implements CommandLineRunner {

    @Autowired
    private StudentRepository stdRepo;

    @Autowired
    private CourseRepository crsRepo;

    @Override
    public void run(String... args) throws Exception{
        Course c1 = new Course(1, "PP1", "Programming Principles 1");
        Course c2 = new Course(2, "PP2", "Programming Principles 2");
        Course c3 = new Course(3, "WM2", "Web and Mobile 2");
        Course c4 = new Course(4, "DSA", "Data structures and algorithms");

        crsRepo.save(c1);
        crsRepo.save(c2);
        crsRepo.save(c3);
        crsRepo.save(c4);

        List<Course> list1 = new ArrayList<>();
        list1.add(c3);
        list1.add(c4);

        List<Course> list2 = new ArrayList<>(list1);
        list2.add(c2);

        List<Course> list3 = new ArrayList<>();
        list3.add(c3);
        list3.add(c2);

        Student me = new Student(1, "Nuraddin", "Sadili", 3.1, list2);
        stdRepo.save(me);

        Student st1 = new Student(2, "Minura", "Hajisoy", 4.0, list1);
        Student st2 = new Student(3, "Kanan", "Gafarov", 3.8, list3);
        Student st3 = new Student(4, "Huseyn", "Jabbarov", 2.9, list2);

        stdRepo.save(st1);
        stdRepo.save(st2);
        stdRepo.save(st3);
    }
}
