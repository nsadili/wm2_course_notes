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

    @GetMapping
    @ResponseStatus(HttpStatus.OK) //200
    public List<ProductDto> listProducts() {
        return productService.list();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long id) {
        Optional<Product> res = productService.getById(id);

        return res.isEmpty()
                ? new ResponseEntity<>(null, HttpStatus.NO_CONTENT)
                : ResponseEntity.ok(res.get());
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeById(@PathVariable("productId") Long id) {
        productService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public Product saveProduct(@RequestBody Product product) {
        Product newP = productService.save(product);
//        new ResponseEntity(newP, HttpStatus.CREATED);
        return newP;
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long id, @RequestBody Product newP) {
        Optional<Product> res = productService.update(id, newP);

        return res.isEmpty()
                ? new ResponseEntity<>(null, HttpStatus.NO_CONTENT)
                : ResponseEntity.ok(res.get());
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long id,
                                                 @RequestBody Map<String, Object> params) {
        Optional<Product> res = productService.partialUpdate(id, params);

        return res.isEmpty()
                ? new ResponseEntity<>(null, HttpStatus.NO_CONTENT)
                : ResponseEntity.ok(res.get());
    }

}
