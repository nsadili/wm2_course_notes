package az.edu.ada.wm2.myfirstspringapp.controller;

import az.edu.ada.wm2.myfirstspringapp.model.BookModel;
import az.edu.ada.wm2.myfirstspringapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("booksList", bookService.listBooks());
        return "list-books";
    }

    @GetMapping("/create")
    public String createBookPage(Model model) {
        model.addAttribute("book", new BookModel());
        return "create-book";
    }

    @PostMapping("/create")
    public String createBookAction(@ModelAttribute BookModel bookModel) {
        bookService.createBook(bookModel);
        return "redirect:/books";
    }

    @GetMapping("/update/{bookId}")
    public String updateBookView(@PathVariable String bookId, Model model) {
        model.addAttribute("book", bookService.getBook(bookId));
        return "edit-book";
    }

    @PostMapping("/update/{bookId}")
    public String updateBookAction(@PathVariable String bookId, @ModelAttribute BookModel bookModel, Model model) {
        bookService.editBook(bookId, bookModel);
        return "redirect:/books";
    }

    @GetMapping("/delete/{bookId}")
    public String deleteBookView(@PathVariable String bookId, Model model) {
        model.addAttribute("book", bookService.getBook(bookId));
        return "delete-book";
    }

    @PostMapping("/delete/{bookId}")
    public String deleteBookAction(@PathVariable String bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books";
    }

}
