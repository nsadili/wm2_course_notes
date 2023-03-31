package webII.com.example.Web.II.Project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    @Autowired
    @Qualifier("greetText")
    private String welcomeMessage;

    @Autowired
    @Qualifier("byeText")
    private String farewellMessage;

    @GetMapping("/")
    public String getWelcome(Model model) {
        model.addAttribute("message",welcomeMessage);
        return "welcome";
    }

    @GetMapping("/bye")
    public String getBye(Model model) {
        model.addAttribute("message",farewellMessage);
        return "welcome";
    }
}
