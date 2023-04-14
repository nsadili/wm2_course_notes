package az.edu.ada.wm2.resfuldemo.controller;

import az.edu.ada.wm2.resfuldemo.model.entity.Product;
import az.edu.ada.wm2.resfuldemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController{

  private ProductService productService;

  public ProductController(ProductService productService){
    this.productService = productService;
  }

  @GetMapping("")
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody
  List<Product> listAll() {
    return productService.list();
  }

  @GetMapping("/{productId}")
  public ResponseEntity<Product> getById(@PathVariable("productId") Long id){
    Optional<Product> res = productService.getById(id);

    return res.isPresent()
      ? new ResponseEntity<>(res.get(), HttpStatus.OK)
      : ResponseEntity.noContent().build();
  }

  @PostMapping
  public @ResponseBody Product saveProduct(@RequestBody Product product){
  return productService.save(product);


  }

  @PutMapping("/{productId}")
  public ResponseEntity<Product> update(@PathVariable("productId") Long id,
                                        @RequestBody Product product){
    Optional <Product> res = productService.update(id, product);
    return res.isPresent()
    ? new ResponseEntity<>(res.get(), HttpStatus.OK)
    : ResponseEntity.noContent().build();
  }
}