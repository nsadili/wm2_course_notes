package az.edu.ada.wm2.first_spring_boot_app.controller;

import az.edu.ada.wm2.first_spring_boot_app.bean.StudentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

    @Autowired
    private String greetText;

    @Autowired
    private StudentBean defaultStudent;

    @GetMapping("/")
    public String getGreetings(Model model) {
        model.addAttribute("message", greetText + " by " + defaultStudent);
        return "greeting";
    }

}
