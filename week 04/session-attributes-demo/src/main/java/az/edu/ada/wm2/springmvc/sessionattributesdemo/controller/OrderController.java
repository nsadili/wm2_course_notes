package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
@Controller
@RequestMapping("/orders")
public class OrderController {


    @GetMapping("/")
    public String listOrderDetails(Model model, @SessionAttribute Order order){
        model.addAttribute("order", order);
        return "orders/order_detail";
    }


    @PostMapping("/save")
    public String saveOrder(@RequestParam String customerName,@SessionAttribute Order order,
                            WebRequest request, SessionStatus status){
        order.setCustomerName(customerName);
        //save operations
        System.out.println("Saving the order: " +order);
        status.setComplete();
        request.removeAttribute("order",1);
        return "redirect:/products/list";

    }
}
