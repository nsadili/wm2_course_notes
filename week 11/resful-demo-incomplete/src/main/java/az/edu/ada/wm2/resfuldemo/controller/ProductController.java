package az.edu.ada.wm2.resfuldemo.controller;

import az.edu.ada.wm2.resfuldemo.model.dto.ProductDto;
import az.edu.ada.wm2.resfuldemo.model.entity.Product;
import az.edu.ada.wm2.resfuldemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces =  "application/xml")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> listAll() {
        return productService.list();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getById(@PathVariable Long productId) {
        Optional<Product> res = productService.getById(productId);

        return res.isPresent() ? new ResponseEntity<>(res.get(), HttpStatus.OK)
                            : ResponseEntity.noContent().build();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED) //201
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(@PathVariable Long productId, @RequestBody Product product) {

        Optional<Product> res = productService.update(productId, product);

        return res.isPresent() ? new ResponseEntity<>(res.get(), HttpStatus.OK)
                : ResponseEntity.noContent().build();
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> partialUpdate(@PathVariable Long productId, @RequestBody Map<String, Object> params) {

        Optional<Product> res = productService.partialUpdate(productId, params);

        return res.isPresent() ? new ResponseEntity<>(res.get(), HttpStatus.OK)
                : ResponseEntity.noContent().build();
    }
}
