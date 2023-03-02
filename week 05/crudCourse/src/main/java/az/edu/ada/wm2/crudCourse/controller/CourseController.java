package az.edu.ada.wm2.crudCourse.controller;

import az.edu.ada.wm2.crudCourse.entity.Course;
import az.edu.ada.wm2.crudCourse.service.CourseService;
import az.edu.ada.wm2.crudCourse.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping({"/","/list"})
    public String getAllCourses(Model model){
        model.addAttribute("courses", courseService.list());
        return "index";
    }

    @GetMapping("/newCourse")
    public ModelAndView showNewCoursePage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("new_course");
        mv.addObject("course", new Course());
        return mv;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Course course){
        courseService.save(course);
        return "redirect:/courses/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable String id) {
        courseService.deleteById(Integer.valueOf(id));
        return "redirect:/courses/";
    }
    @GetMapping("/update/{id}")
    public ModelAndView updateCourse(@PathVariable String id) {
        ModelAndView mv = new ModelAndView("update_course");
        // mv.setViewName("update_person");
        mv.addObject("course", courseService.getById(Integer.valueOf(id)));
        return mv;
    }
}