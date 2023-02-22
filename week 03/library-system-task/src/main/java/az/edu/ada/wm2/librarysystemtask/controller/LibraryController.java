package az.edu.ada.wm2.librarysystemtask.controller;

import az.edu.ada.wm2.librarysystemtask.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import az.edu.ada.wm2.librarysystemtask.model.Library;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;


    @GetMapping({"/", "/list"})
    public String getAllPersons(Model model){
        model.addAttribute("librarys", libraryService.list());


        return "index";


    }
    @GetMapping("/{id}")
    public String getLibraryById(Model model, @PathVariable Integer id) {
        model.addAttribute("library", libraryService.getById(id));
        return "person_info";
    }
    @GetMapping("/newLibrary")
    public ModelAndView showNewLibraryPage(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("new_library");
        mv.addObject("library", new Library());
        return mv;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Library library){
        libraryService.save(library);
        return "redirect:/list";

    }
    @PostMapping("/update")
    public String updateLibrary(@ModelAttribute("library") Library library) {
        libraryService.update(library);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteLibrary(@PathVariable String id) {
        libraryService.deleteById(Integer.valueOf(id));
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateLibrary(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("update");
        mv.addObject("library", libraryService.getById(Integer.valueOf(id)));
        return mv;
    }


}
