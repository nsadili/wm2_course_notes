package az.edu.ada.wm2.thymeleafdemo.controller;

import az.edu.ada.wm2.thymeleafdemo.model.Person;
import az.edu.ada.wm2.thymeleafdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping({"/", "/list"})
    public String getAllPersons(Model model){ //another container carrying the data between controller and the new
        model.addAttribute("personList",personService.list());
        return "index"; //simple html file
    }
    @GetMapping("/newPerson")
    public ModelAndView showNewperson() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("new_person");

        mv.addObject("person", new Person());

        return mv;
    }
    @PostMapping("/save")
    public String savePerson(@ModelAttribute Person person){
        personService.save(person);
        return"redirect:/";
    }

    @GetMapping("/update/{id}")

    public String showUpdatePerson(@PathVariable String id, Model model){
        Person person = personService.getById(id);
        model.addAttribute("person", person);

        return "update_person";
    }

    @GetMapping("/delete/{id}")

    public String deletePerson (@PathVariable("id") String id){
        personService.deleteById(id);

        return"redirect:/";
    }

}

