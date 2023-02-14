package az.edu.ada.wm2.thymeleafdemo.controller;

import az.edu.ada.wm2.thymeleafdemo.model.Person;
import az.edu.ada.wm2.thymeleafdemo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping({"/", "/people"})
    public String getAllPersons(Model model) {
        model.addAttribute("persons", personService.list());
        return "people";
    }

    @GetMapping("/people/create")
    public ModelAndView createPersonView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("new-person");
        mv.addObject("person", new Person());
        return mv;
    }

    @PostMapping("/people/save")
    public String savePerson(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/people/update/{id}")
    public String updatePersonView(@PathVariable String id, Model model) {
        model.addAttribute("person", personService.getById(id));
        return "update";
    }

    @GetMapping("/people/delete/{id}")
    public String deletePersonSave(@PathVariable String id) {
        personService.deleteById(id);
        return "redirect:/people";
    }
}
