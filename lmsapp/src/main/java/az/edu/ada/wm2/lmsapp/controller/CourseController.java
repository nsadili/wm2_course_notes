package az.edu.ada.wm2.lmsapp.controller;

import az.edu.ada.wm2.lmsapp.entity.Course;
import az.edu.ada.wm2.lmsapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping({"", "/list"})
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.listCourses());
        return "course/list";
    }

    @GetMapping("/{id}")
    public String listCourses(Model model, @PathVariable Integer id) {
        model.addAttribute("course", courseService.getById(id));
        return "course/detail";
    }

    @GetMapping("/create")
    public String createCourseView(Model model) {
        model.addAttribute("course", new Course());
        return "course/create";
    }

    @PostMapping("/create")
    public String createCourseAction(@ModelAttribute Course course) {
        courseService.createCourse(course);
        return "redirect:/courses/list";
    }

    @GetMapping("/{id}/update")
    public String updateCourseView(Model model, @PathVariable Integer id) {
        model.addAttribute("course", courseService.getById(id));
        return "course/update";
    }

    @PostMapping("/{id}/update")
    public String updateCourseView(@PathVariable Integer id, @ModelAttribute Course course) {
        courseService.updateCourse(id, course);
        return "redirect:/courses/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteCourseView(Model model, @PathVariable Integer id) {
        model.addAttribute("course", courseService.getById(id));
        return "course/delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteCourseAction(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return "redirect:/courses/list";
    }
}
