package az.edu.ada.wm2.lmsapp.service;

import az.edu.ada.wm2.lmsapp.entity.Course;
import az.edu.ada.wm2.lmsapp.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Iterable<Course> listCourses() {
        return courseRepository.findAll();
    }

    public Page<Course> listCourses(int page) {
        return courseRepository.findAll(PageRequest.of(page - 1, 10));
    }

    public Page<Course> listCourses(int page, int pageSize) {
        return courseRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    public Page<Course> listCourses(int page, int pageSize, String sortBy) {
        Sort sort;

        if (sortBy == null)
            return courseRepository.findAll(PageRequest.of(page - 1, pageSize));

        System.out.println(sortBy);
        sort = sortBy.charAt(0) == '-' ? Sort.by(sortBy.substring(1)).descending() : Sort.by(sortBy);
        System.out.println(sort);

        return courseRepository.findAll(PageRequest.of(page - 1, pageSize, sort));
    }

    public Course getById(Integer id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course) {
        Course oldCourse = courseRepository.findById(id).orElseThrow();

        oldCourse.setName(course.getName());
        oldCourse.setDepartmentName(course.getDepartmentName());
        oldCourse.setCredits(course.getCredits());

        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
