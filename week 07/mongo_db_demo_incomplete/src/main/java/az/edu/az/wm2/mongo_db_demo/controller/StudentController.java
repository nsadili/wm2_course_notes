package az.edu.az.wm2.mongo_db_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/list")
    public String getAllStudents(Model model) {

        model.addAttribute("students", List.of());

        return "student_list";
    }


}
