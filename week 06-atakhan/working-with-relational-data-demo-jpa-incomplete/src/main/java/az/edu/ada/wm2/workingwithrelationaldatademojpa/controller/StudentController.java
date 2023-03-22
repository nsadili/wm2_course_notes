package az.edu.ada.wm2.workingwithrelationaldatademojpa.controller;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.StudentService;
//import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private StudentService studentService;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("students", studentService.list());
        return "students/index";
    }

    @GetMapping("/{firstName}/{lastName}")
    public String getByFirstAndLastName(Model model,
                                        @PathVariable String firstName,
                                        @PathVariable String lastName) {
        model.addAttribute("students",
                studentService.getByFirstAndLastName(firstName, lastName));

        return "students/index";
    }
}
