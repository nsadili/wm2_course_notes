package az.edu.ada.wm2.bookapp.controller;

import az.edu.ada.wm2.bookapp.model.Book;
import az.edu.ada.wm2.bookapp.service.BookService;
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

    @GetMapping({"/books", ""})
    public String getBooks(Model model) {
        model.addAttribute("booksList", bookService.listBooks());
        return "list-books";
    }

    @GetMapping("/create")
    public String createBookPage(Model model) {
        model.addAttribute("book", new Book());
        return "create-book";
    }

    @PostMapping("/create")
    public String createBookAction(@ModelAttribute Book bookModel) {
        bookService.createBook(bookModel);
        return "redirect:/books";
    }

    @GetMapping("/update/{bookId}")
    public String updateBookView(@PathVariable Integer bookId, Model model) {
        model.addAttribute("book", bookService.getBookById(bookId));
        return "update-book";
    }

    @PostMapping("/update/{bookId}")
    public String updateBookAction(@PathVariable Integer bookId, @ModelAttribute Book bookModel) {
        bookService.updateBook(bookId, bookModel);
        return "redirect:/books";
    }

    @GetMapping("/delete/{bookId}")
    public String deleteBookView(@PathVariable Integer bookId, Model model) {
        model.addAttribute("book", bookService.getBookById(bookId));
        return "delete-book";
    }

    @PostMapping("/delete/{bookId}")
    public String deleteBookAction(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books";
    }
}
