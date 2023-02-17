package az.edu.ada.wm2.shoppingapptask.controller;


import az.edu.ada.wm2.shoppingapptask.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import az.edu.ada.wm2.shoppingapptask.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping({"/", "/list"})
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.list());


        return "index";


    }
    @GetMapping("/newProduct")
    public ModelAndView showNewProductPage(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("new_product");
        mv.addObject("product", new Product());
        return mv;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/list";

    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateProduct(@PathVariable String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("update");
        mv.addObject("product", productService.getById(id));
        return mv;
    }

    @Controller
    public class HomeController {

        @GetMapping("/")
        public String index(@ModelAttribute("userName") String userName) {
            return "index";
        }
    }
    @Controller
    public class UserController {

        @PostMapping("/submit-name")
        public String submitName(@RequestParam("userName") String userName, HttpSession session) {
            session.setAttribute("userName", userName);
            return "redirect:/";
        }
    }


}