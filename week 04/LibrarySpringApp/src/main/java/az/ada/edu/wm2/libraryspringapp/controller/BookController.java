package az.ada.edu.wm2.libraryspringapp.controller;

import az.ada.edu.wm2.libraryspringapp.model.Book;
import az.ada.edu.wm2.libraryspringapp.model.Library;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"library"})
@RequestMapping("/library")
public class BookController {
    @GetMapping({"/list", "/", ""})
    public String showLibrary(Model model, @ModelAttribute Library library) {
        model.addAttribute("library", (library == null) ? new Library() : library);
        return "library/list";
    }
    @GetMapping("/create")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "library/create";
    }
    @PostMapping("/addToLibrary")
    public String addToLibrary(Model model, @ModelAttribute Library library, @ModelAttribute Book book) {
        if (library == null)
            library = new Library();
        library.addBook(book);
        model.addAttribute("library", library);

        return "redirect:/library/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateBook(@PathVariable String id, @ModelAttribute Library library) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("library/update");

        for(Book foundBook : library.getBooks()) {

            if(foundBook.getId().equals(id))
                mv.addObject("book", foundBook);
        }
        return mv;
    }

    @PostMapping("/updateBook")
    public String updatedBook(@ModelAttribute Book book, @ModelAttribute Library library) {
        for(Book foundBbook : library.getBooks()) {
            if(foundBbook.getId().equals(book.getId())) {
                foundBbook.setTitle(book.getTitle());
                foundBbook.setDescription(book.getDescription());
                foundBbook.setYear(book.getYear());
                foundBbook.setAuthor(book.getAuthor());
            }
        }
        return "redirect:/library/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable String id, @ModelAttribute Library library) {
        
        Book foundBook = null;
        for(Book book : library.getBooks()) {
            if(book.getId().equals(id)) {
                foundBook = book;
            }
        }
        library.getBooks().remove(foundBook);
        return "redirect:/library/list";
    }

    //AutoWired for Library
    @ModelAttribute
    public Library library() {
        return new Library();
    }
}
