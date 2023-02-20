package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@SessionAttributes({"order", "currentUser"})
public class ProductsController {
    @GetMapping({"list","/"})
    public String listProducts(Model model,
                               @ModelAttribute Order order){
        model.addAttribute("order",order==null? new Order():order);
        return "products/list";
    }

    @PostMapping("addToOrder")
    public String addProductToOrder(@RequestParam("product") String productId,
                                    @ModelAttribute Order order){
        order.addProduct(productId);
        System.out.println(productId);
        System.out.println(order);

        return "redirect:/products/";
    }

    @ModelAttribute //first time comes here to instantiate and inject
    public Order order(){
        return new Order();
    }
}
