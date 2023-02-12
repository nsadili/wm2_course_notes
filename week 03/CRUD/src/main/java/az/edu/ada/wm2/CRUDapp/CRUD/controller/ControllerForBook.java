package az.edu.ada.wm2.CRUDapp.CRUD.controller;

import az.edu.ada.wm2.CRUDapp.CRUD.model.Book;
import az.edu.ada.wm2.CRUDapp.CRUD.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerForBook {
    @Autowired
    private BookService BS;

    @GetMapping({"/","/books"})
    public String getAllBooks(Model model){
        model.addAttribute("books_list",BS.list());
        return "list_of_books";
    }

    @GetMapping("/newBook")
    public String addNewBook(Model model) {
        model.addAttribute("book", new Book());
        return "new_book";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        BS.save(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        BS.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateBook(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("update_book");
        mv.addObject("book", BS.getById(id));
        return mv;
    }

}
