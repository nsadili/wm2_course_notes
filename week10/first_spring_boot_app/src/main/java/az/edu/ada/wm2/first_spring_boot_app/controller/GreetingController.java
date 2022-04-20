package az.edu.ada.wm2.first_spring_boot_app.controller;

import az.edu.ada.wm2.first_spring_boot_app.bean.StudentBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class GreetingController {

    @Autowired
    @Qualifier("greetingText")
    private String greetText;

    @Autowired
    @Qualifier("anyMessage")
    private String randomMessage;

    @Autowired
    @Qualifier("farewellText")
    private String byebye;

    @Autowired
    private StudentBean defaultStudent;

    Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/")
    public String getGreetings(Model model) {
        System.out.println(defaultStudent);
        model.addAttribute("message", greetText + " || " + byebye);

        logger.error("Be carefull, this is an error message");

        return "greeting";
    }

    @GetMapping("/testDate")
    public String testDate(Model model, @RequestParam("startDate") Date date) {

        return "greeting";
    }

}
