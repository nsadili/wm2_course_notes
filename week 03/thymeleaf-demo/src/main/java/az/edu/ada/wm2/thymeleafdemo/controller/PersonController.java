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

    @GetMapping({"/","/list"})
    public String getAllPersons(Model model) {
        model.addAttribute("personList",personService.list());
        return "list_people";
    }

    @GetMapping("/newPerson")
    public String createNewPerson(Model model) {
        model.addAttribute("person", new Person());
        return "new_person";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") Person person) {
        personService.save(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable String id) {
        personService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePerson(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("update_person");
        mv.addObject("person", personService.getById(id));
        return mv;
    }


}

