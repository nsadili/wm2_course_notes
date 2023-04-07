package az.edu.ada.wm2.springbootsecurityframeworkdemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class BusinessController {

    @GetMapping("/users")
    public String getUsersHomePage(Model model) {
        model.addAttribute("message", "This is home for users");
        return "welcome";
    }

    @GetMapping("/admins")
    public String getAdminsHomePage(Model model) {
        model.addAttribute("message", "This is home for admins");
        return "welcome";
    }


}
