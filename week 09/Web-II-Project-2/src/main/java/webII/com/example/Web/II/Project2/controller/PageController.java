package webII.com.example.Web.II.Project2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/products")
    public String getUserPages(Model model){
        model.addAttribute("message", "This is default users page");
        return "welcome";
    }

    @GetMapping("/bills")
    public String getAdminPage(Model model){
        model.addAttribute("message", "This is default admin page");
        return "welcome";
    }
}
