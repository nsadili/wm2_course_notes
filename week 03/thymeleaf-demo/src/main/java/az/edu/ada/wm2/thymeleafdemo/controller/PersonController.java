package az.edu.ada.wm2.thymeleafdemo.controller;

import az.edu.ada.wm2.thymeleafdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping({"/", "/list"})
    public String getAllPersons(Model model){
        model.addAttribute("personList",personService.list());
        return "index"; //simple html file
    }
    @GetMapping("/newPerson")
    public ModelAndView showNewperson(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("new_person");

        return mv;
    }

}

