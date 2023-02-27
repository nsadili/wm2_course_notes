package az.edu.ada.wm2.courseentitytask.service;

import az.edu.ada.wm2.courseentitytask.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    static final List<Course> courses;

    static {
        courses = new ArrayList<>();
        courses.add(new Course(UUID.randomUUID().toString(), "Rafael", "site","50"));
        courses.add(new Course(UUID.randomUUID().toString(), "Ali", "spia","60"));
        courses.add(new Course(UUID.randomUUID().toString(), "Jale", "sb","70"));
    }

    @Override
    public List<Course> list() {
        return courses;
    }

    @Override
    public Course getById(String id) {
        Optional<Course> result = courses.stream()
                .filter(course -> course.getId().equals(id))
                .findAny();
        return result.orElse(new Course());
    }

    @Override
    public Course save(Course course) {
        if (course.getId() == null) {
            course.setId(UUID.randomUUID().toString());
            courses.add(course);

            return course;
        }


        Optional<Course> result = courses.stream()
                .filter(c -> c.getId().equals(course.getId()))
                .findAny();

        Course oldRecord = result.orElseThrow();

        oldRecord.setName(course.getName());
        oldRecord.setDepartmentname(course.getDepartmentname());
        oldRecord.setCredits(course.getCredits());


        return oldRecord;
    }

    @Override
    public void deleteById(String id) {
        Optional<Course> result = courses.stream()
                .filter(course -> course.getId().equals(id))
                .findAny();

        if (result.isPresent())
            courses.remove(result.get());
    }


}