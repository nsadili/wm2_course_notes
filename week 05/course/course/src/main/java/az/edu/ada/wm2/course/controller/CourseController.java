package az.edu.ada.wm2.course.controller;

import az.edu.ada.wm2.course.entity.Course;
import az.edu.ada.wm2.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/{id}")
    public String showUserForm(@PathVariable("id")Course course,
                               Model model){
        model.addAttribute("course", course);
        return "userForm";

    }
    //private CourseService courseService;
}