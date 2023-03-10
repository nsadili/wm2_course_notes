package az.edu.ada.wm2.workingwithrelationaldatademojpa.controller;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studService;
    @GetMapping({"","/", "/list"})
    public String list(Model model){
        model.addAttribute("students", studService.list());
        return "students/index";
    }

    @GetMapping("/{firstName}/courses")
    public String getByFirstAndLastName(Model model,
                                        @PathVariable String firstName,
                                        @PathVariable String lastName){
        model.addAttribute("students",
                studService.getByFirstAndLastName(firstName, lastName));
    }

}
