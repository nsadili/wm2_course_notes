package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @GetMapping ({"/list", "/"})
    public String ListProducts(Model model) {


        return "products/list";
    }

    @PostMapping("addToOrder")
    public String addProductToOrder(@RequestParam("product") String productId){
    System.out.println(productId);
    return "redirect:/products/";
    }
}
