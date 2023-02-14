package az.edu.ada.wm2.thymeleafdemo.controller;

import az.edu.ada.wm2.thymeleafdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

}

@GetMapping({"/", "list"})

public String getAllPersons(Model model){

    model.addAttribute("persons", personService.list());

    return "index";



}
@GetMapping("/newPerson")
public String showNewPersonPage(){

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



