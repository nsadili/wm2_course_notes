package az.edu.ada.wm2.workingwithrelationaldatademojpa.controller;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    StudentService studentService;

    public StudentController(StudentService studentService) { this.studentService = studentService;}

    @GetMapping({"", "/", "list"})
    public String listAll(Model model){
        model.addAttribute("student", new Student());
        return "students/index";
    }

    @GetMapping("/new")
    public String createNewStudent(Model model) {
        model.addAttribute("student", new Student());
        LOGGER.info("createNewStudent()");
        return "students/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student/";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("student", studentService.getById(id));
        return "student/info";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/student/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateStudent(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/update");

        mv.addObject("student", studentService.getById(id));
        return mv;
    }



}
