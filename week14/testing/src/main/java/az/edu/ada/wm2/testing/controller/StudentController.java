package az.edu.ada.wm2.testing.controller;

import az.edu.ada.wm2.testing.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/new")
    public String showEditForm(Model model) {
        model.addAttribute("student", new Student());
        return "student_form";
    }

}
