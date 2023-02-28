package com.example.coursecrud.controller;

import com.example.coursecrud.model.Course;
import com.example.coursecrud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
    @Autowired
    public CourseService courseService;

    @GetMapping({"/", "/list"})
    public String getAll(Model model) {
        model.addAttribute("courses", courseService.getAll());

        return "list";
    }

    @GetMapping("/new")
    public String createCourse(Model model) {
        model.addAttribute("course", new Course());

        return "new";
    }

    @GetMapping("/update/{id}")
    public String updateCourse(@PathVariable Integer id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourseById(id);

        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        System.out.println(course.toString());
        return "redirect:/";
    }

}
