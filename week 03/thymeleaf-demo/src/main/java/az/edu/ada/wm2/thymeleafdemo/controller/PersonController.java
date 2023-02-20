package az.edu.ada.wm2.thymeleafdemo.controller;

import az.edu.ada.wm2.thymeleafdemo.model.Person;
import az.edu.ada.wm2.thymeleafdemo.service.PersonService;
import az.edu.ada.wm2.thymeleafdemo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping({"/" , "list"})


public String getAllPersons(Model model){

model.addAttribute( "personList",personService.list());

        return "index";
}

@GetMapping("/newPerson")
    public ModelAndView showNewPersonPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("new_person");
        mv.addObject("person", new Person());
        return mv;
}
@PostMapping("/save")
    public String save(@ModelAttribute Person person){
        personService.save(person);

        return "redirect:/";
}
}

