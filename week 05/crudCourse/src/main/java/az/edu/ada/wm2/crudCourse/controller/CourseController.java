package az.edu.ada.wm2.crudCourse.controller;

import az.edu.ada.wm2.crudCourse.entity.Course;
import az.edu.ada.wm2.crudCourse.service.CourseService;
import az.edu.ada.wm2.crudCourse.service.impl.CourseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CourseController {

    @GetMapping("/list")
    public String getBooks(Model model) {
        model.addAttribute("course");

        List<Course> courses = new CourseServiceImpl().list();

        model.addAttribute("courses", courses;
        return "course_list";
    }

    @GetMapping("/{id}")
    public String showUserForm(@PathVariable("id") Course course,
                               Model model) {
        model.addAttribute("course", course);
        return "user_form";
    }
}