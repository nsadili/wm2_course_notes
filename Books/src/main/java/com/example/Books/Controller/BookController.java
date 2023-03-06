package com.example.Books.Controller;

import com.example.Books.Model.Book;
import com.example.Books.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String getBook(Model model) {

        List<Book> book = bookService.getList();

        model.addAttribute("books", book);


        return "book_list";
    }

    @GetMapping("/delete/{id}")

    public String deleteBook(Model model, @PathVariable Integer id) throws Exception {

        try {
            if (!bookService.exist(id)) {
                throw new Exception("Book does not exist");
            } else {
                bookService.delete(id);
                model.addAttribute("interviewee", bookService.delete(id));

            }
        } catch (Exception ignore) {
            System.out.println("interviewee is deleted!");
        }
        return "redirect:/book/list";
    }

    @PostMapping("/save")
    public String saveInterviewee(Model model, Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return "book_form";

        }
        Book updatedBook = bookService.saveBook(book);
        model.addAttribute("book", updatedBook);

        return "book_info";

    }
    @GetMapping("/create") //creating new interviewee
    public String getNewBookForm(Model model) {
        model.addAttribute("book", new Book());

        return "book_form";
    }
}

