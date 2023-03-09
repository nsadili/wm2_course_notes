package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

import org.springframework.ui.Model;


@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping({"/", "list"})
    public String getAllCourses(Model model) {
        model.addAttribute("courseList", courseService.list());
        return "home";
    }

    @GetMapping("/{id}")
    public String getCourseById(Model model, @PathVariable Integer id) {
        model.addAttribute("course", courseService.getById(id));
        return "course_info";
    }

    @GetMapping("/newCourse")
    public String createNewCourse(Model model) {
        model.addAttribute("course", new Course());
        return "new_course";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute("course") Course course) {
        courseService.update(course);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        courseService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateCourse(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("update_course");

        mv.addObject("course", courseService.getById(id));
        return mv;
    }
}


