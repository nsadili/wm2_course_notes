package az.edu.ada.wm2.courseentitytask.controller;

import az.edu.ada.wm2.courseentitytask.model.Course;
import az.edu.ada.wm2.courseentitytask.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;


    @GetMapping({"/", "/list"})
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
        return "redirect:/list";

    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable String id) {
        courseService.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateCourse(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("update");
        mv.addObject("course", courseService.getById(id));
        return mv;
    }


}