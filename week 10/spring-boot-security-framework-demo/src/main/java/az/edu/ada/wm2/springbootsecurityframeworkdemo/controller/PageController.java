package az.edu.ada.wm2.springbootsecurityframeworkdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/users")
    public String getUserPages(Model model){
        model.addAttribute("message", "This is default users page");
        return "welcome";
    }

    @GetMapping("/admins")
    public String getAdminPages(Model model){
        model.addAttribute("message", "This is default admins page");
        return "welcome";
    }
}
