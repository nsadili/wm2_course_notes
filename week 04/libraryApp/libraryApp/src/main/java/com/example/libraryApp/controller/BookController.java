package com.example.libraryApp.controller;

import com.example.libraryApp.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/")
public class BookController {
    @GetMapping("/")
    public String listOrderDetails(@SessionAttribute Book book, Model model){

        model.addAttribute("book", book);
        return "/book_detail";
    }

    @PostMapping("/save")
    public String saveOrder(@RequestParam String bookName, @SessionAttribute Book book,
                            WebRequest request, SessionStatus status){
        book.setBook(bookName);
        //save
        System.out.println(book);

        status.setComplete();

        request.removeAttribute("book", 1); //1 session, 0 request
        return "redirect:/";
    }
}
