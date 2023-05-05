package az.edu.ada.wm2.thymeleafdemo.controller;

import az.edu.ada.wm2.thymeleafdemo.model.Person;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======

>>>>>>> 4b3cd23 (working on application thymeleaf-demo)
import az.edu.ada.wm2.thymeleafdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class PersonController {
    @Autowired
    private PersonService personService;


<<<<<<< HEAD
    @GetMapping({"/", "/list"})
=======
    @GetMapping({"/", "list"})
>>>>>>> 4b3cd23 (working on application thymeleaf-demo)
    public String getAllPersons(Model model){
        model.addAttribute("persons", personService.list());


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
<<<<<<< HEAD
        return "redirect:/list";

    }

    @GetMapping("/delete/{id}")
            public String deletePerson(@PathVariable String id) {
                personService.deleteById(id);
                return "redirect:/list";
    }

   @GetMapping("/update/{id}")
            public ModelAndView updatePerson(@PathVariable String id) {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("update");
                mv.addObject("person", personService.getById(id));
                return mv;
        }


    }
=======
        return "redirect:/";


    }
}
>>>>>>> 4b3cd23 (working on application thymeleaf-demo)

