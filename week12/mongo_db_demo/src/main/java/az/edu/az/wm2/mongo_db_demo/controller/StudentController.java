package az.edu.az.wm2.mongo_db_demo.controller;

import az.edu.az.wm2.mongo_db_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService stdService;

    @GetMapping("/list")
    public String getAllStudents(Model model){

        model.addAttribute("students", stdService.getAllStudents());

        return "student_list";
    }

    @GetMapping("/list/between")
    public String getAllStudents(Model model, Double min, Double max){

        model.addAttribute("students", stdService.getAllStudentsWithGradeBetween(min, max));

        return "student_list";
    }

}
