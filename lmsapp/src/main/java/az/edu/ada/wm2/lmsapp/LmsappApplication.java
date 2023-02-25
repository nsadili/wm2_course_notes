package az.edu.ada.wm2.lmsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class LmsappApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsappApplication.class, args);
    }

    @GetMapping("")
    public String redirectToCourses() {
        return "redirect:/courses";
    }
}
