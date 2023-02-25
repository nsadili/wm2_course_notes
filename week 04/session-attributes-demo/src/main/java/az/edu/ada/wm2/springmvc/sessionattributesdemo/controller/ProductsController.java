package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@SessionAttributes({"order"})
public class ProductsController {

    @GetMapping({"list","/"})
    public String listProducts(Model model, @ModelAttribute Order order){
        model.addAttribute("order", order == null ? new Order() : order);
        return "products/list";
    }

    @PostMapping("addToOrder")
    public String addProductToOrder(@RequestParam("product") String productId,
                                    @ModelAttribute Order order,
                                    Model model){
        if (order == null) order = new Order();
        if (productId != null && !productId.isBlank()) order.addProduct(productId);
        model.addAttribute("order",order);
        return "redirect:/products/list";
    }

    @ModelAttribute
    public Order order() {
        return new Order();
    }
}
