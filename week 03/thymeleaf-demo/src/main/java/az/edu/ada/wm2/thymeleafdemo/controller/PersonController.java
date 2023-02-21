package az.edu.ada.wm2.thymeleafdemo.controller;

<<<<<<< HEAD
=======
import az.edu.ada.wm2.thymeleafdemo.model.Person;
>>>>>>> origin/nuraddin_sadili_1
import az.edu.ada.wm2.thymeleafdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
>>>>>>> origin/nuraddin_sadili_1

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping({"/", "list"})
    public String getAllPersons(Model model) {
        model.addAttribute("persons", personService.list());
        return "index";
    }
<<<<<<< HEAD
=======

    @GetMapping("/newPerson")
    public ModelAndView showNewPersonPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("new_person");
        mv.addObject("person", new Person());

        return mv;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute  Person person){
        personService.save(person);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdatePage(@PathVariable String id){
        Person found = personService.getById(id);
        ModelAndView mv = new ModelAndView("update_person");
        mv.addObject("person", found);

        return mv;
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable String id, Model model){
        personService.deleteById(id);
        return "redirect:/";
    }

>>>>>>> origin/nuraddin_sadili_1
}

