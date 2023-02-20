package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;


@Controller
@SessionAttributes({"order"})
@RequestMapping("/products")
public class ProductsController {

  @PostMapping("/addToOrder")
  public String addToOrder(Model model, @ModelAttribute Order order,
                           @RequestParam("product") String product) {
    if (order == null)
      order = new Order();

    if (product != null && !product.isBlank())
      order.addProduct(product);
    model.addAttribute("order", order);

    return "redirect:/products/list";
  }

  @GetMapping("/list")
  public String showProductList(Model model, @ModelAttribute Order order) {
    model.addAttribute("order", (order == null) ? new Order() : order);
    return "products/list";
  }

  @ModelAttribute
  public Order order() {
    return new Order();
  }

}
