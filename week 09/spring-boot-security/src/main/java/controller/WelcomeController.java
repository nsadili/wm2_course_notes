package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @Autowired
    @Qualifier("welcomeMessage")
    private String welcomeText;

    @Autowired
    @Qualifier("farewellMessage")
    private String farewellText;

    @GetMapping("/")
    public String welcomePage(Model model){
        model.addAttribute("message", welcomeText);
        return "welcome";
    }

    @GetMapping("/bye")
    public String farewellPage(Model model){
        model.addAttribute("message", farewellText);
        return "welcome";
    }


}