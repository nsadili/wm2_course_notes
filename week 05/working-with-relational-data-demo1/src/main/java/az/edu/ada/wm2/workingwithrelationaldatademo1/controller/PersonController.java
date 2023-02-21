package az.edu.ada.wm2.workingwithrelationaldatademo1.controller;


import az.edu.ada.wm2.workingwithrelationaldatademo1.model.Person;
import az.edu.ada.wm2.workingwithrelationaldatademo1.service.PersonService;
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

    @GetMapping({"/", "list"})
    public String getAllPersons(Model model) {
        model.addAttribute("personList", personService.list());
        return "home";
    }

    @GetMapping("/{id}")
    public String getPersonById(Model model, @PathVariable Integer id) {
        model.addAttribute("person", personService.getById(id));
        return "person_info";
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

    @PostMapping("/update")
    public String updatePerson(@ModelAttribute("person") Person person) {
        personService.update(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id) {
        personService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePerson(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("update_person");

        mv.addObject("person", personService.getById(id));
        return mv;
    }
}

