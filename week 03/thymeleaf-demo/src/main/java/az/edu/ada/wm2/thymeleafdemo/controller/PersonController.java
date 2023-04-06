package az.edu.ada.wm2.thymeleafdemo.controller;

import az.edu.ada.wm2.thymeleafdemo.model.Person;
import az.edu.ada.wm2.thymeleafdemo.service.PersonService;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping({"/", "list"})
    public String getAllPersons(Model model) {
        model.addAttribute("persons", personService.list());
        return "index";
    }
}
