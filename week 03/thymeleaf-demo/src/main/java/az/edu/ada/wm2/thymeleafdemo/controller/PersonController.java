package az.edu.ada.wm2.thymeleafdemo.controller;

import az.edu.ada.wm2.thymeleafdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping({"/", "/list"})
    public String getAllPersons(Model model){
        model.addAttribute("personList", personService.list());

        return "index";
    }

}

