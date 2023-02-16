package com.example.libapp.controller;

import com.example.libapp.model.Book;
import com.example.libapp.view.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    public BookServiceImpl bookService;

    private Book bookContainer;

    @GetMapping({"/","/books"})
    public String getBooksPage(Model m) {
        m.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/newbook")
    public String addNewBook(Model m) {
        m.addAttribute("book", new Book());
        return "modify";
    }

    @PostMapping("/save")
    public String saveChanges(@ModelAttribute Book newBook) {
        bookService.save(newBook);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String removeBook(@PathVariable long id) {
        bookService.remove(id);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String getUpdateRequest(@PathVariable long id, Model model) {
        bookContainer = bookService.getBookById(id);
        return "redirect:/update";
    }

    @GetMapping("/update")
    public String getUpdatePage(Model model) {
        model.addAttribute("book", bookContainer);
        return "modify";
    }
}
