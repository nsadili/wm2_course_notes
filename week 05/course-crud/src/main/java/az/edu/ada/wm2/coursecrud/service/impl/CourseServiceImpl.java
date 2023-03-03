package az.edu.ada.wm2.coursecrud.service.impl;

import az.edu.ada.wm2.coursecrud.model.Course;
import az.edu.ada.wm2.coursecrud.repo.CourseRepository;
import az.edu.ada.wm2.coursecrud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepo;

    @Override
    public List<Course> list(){
        return (List<Course>) courseRepo.findAll();
    }

    @Override
    public Course getById(Integer id){ return courseRepo.findById(id).orElse(null); }

    @Override
    public Course save(Course course){
        return courseRepo.save(course);
    }

    @Override
    public void update(Course course) {
        Optional<Course> result = courseRepo.findById(course.getId());

        Course oldRecord = result.orElseThrow(() -> new RuntimeException("Course not found"));

        oldRecord.setCourse_name(course.getCourse_name());
        oldRecord.setCourse_fac(course.getCourse_fac());

        courseRepo.save(oldRecord);
    }

    public void deleteById(Integer id) {
        courseRepo.deleteById(id);
    }



}
