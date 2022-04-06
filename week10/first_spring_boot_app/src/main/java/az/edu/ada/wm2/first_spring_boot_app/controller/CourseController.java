package az.edu.ada.wm2.first_spring_boot_app.controller;

import az.edu.ada.wm2.first_spring_boot_app.entity.Course;
import az.edu.ada.wm2.first_spring_boot_app.entity.Student;
import az.edu.ada.wm2.first_spring_boot_app.service.CourseService;
import az.edu.ada.wm2.first_spring_boot_app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String getCourses(Model model, @RequestParam String school) {

        model.addAttribute("school", school);

        List<Course> courses = courseService.getCourseList();

        model.addAttribute("courses", courses);

        return "course_list";
    }

    @GetMapping("/web")
    public String getWebCourses(Model model){
        model.addAttribute("courses", courseService.getAllWebCourses());

        return "course_list";
    }
}
