package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping({"/", "/list"})
    public String showOrderDetails(@SessionAttribute("order") Order order, Model model) {
        model.addAttribute("order", order);
        return "orders/order_detail";
    }

    @PostMapping("/save")
    public String save(@SessionAttribute Order order,
                       @RequestParam("customerName") String customerName,
                       WebRequest webRequest,
                       DefaultSessionAttributeStore sas,
                       SessionStatus ss) {
        order.setCustomerName(customerName);
        System.out.println(order);

//        set the session processing as complete allow for cleanup of the attributes
        ss.setComplete();

//        remove the order attribute from the session: v1
        sas.cleanupAttribute(webRequest, "order");

//        remove the order attribute from the session: v2
//        webRequest.removeAttribute("order", 1);

        return "redirect:/products/list";
    }


}
