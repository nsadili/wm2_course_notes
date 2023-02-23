//package az.ada.edu.wm2.libraryspringapp.controller;
//
//import az.ada.edu.wm2.libraryspringapp.model.Book;
//import az.ada.edu.wm2.libraryspringapp.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttribute;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("/library")
//public class LibraryController {
//
//    @Autowired
//    private BookService bookService;
//
//    @GetMapping("list/{id}")
//    public ModelAndView updateBook(@SessionAttribute("book") Book book, Model model, @PathVariable String id) {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("update_book");
//
//        mv.addObject("bok", bookService.getById(id));
//        return mv;
//    }
//}
