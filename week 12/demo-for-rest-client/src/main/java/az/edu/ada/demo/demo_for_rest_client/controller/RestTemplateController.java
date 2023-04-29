package az.edu.ada.demo.demo_for_rest_client.controller;

import az.edu.ada.demo.demo_for_rest_client.dto.ProductResultDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping
    public ProductResultDto[] getAllProducts() {
        var res = restTemplate.getForEntity("http://localhost:8080/api/v1/products", ProductResultDto[].class);
        var products = res.getBody();

        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResultDto> getProductById(@PathVariable Integer id) {

//        var params = new HashMap<>();
//        params.put("id", id);

        var product = restTemplate.getForObject("http://localhost:8080/api/v1/products/{id}", ProductResultDto.class,
                Map.of("id", id));

        return product == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(product);
    }

    @PutMapping
    public void updateProduct(ProductResultDto product, @PathVariable Integer id) {
        restTemplate.put(
                "http://localhost:8080/product/{id}",
                product, product.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(ProductResultDto product, @PathVariable Integer id) {
        restTemplate.delete(
                "http://localhost:8080/product/{id}",
                product, product.getId());
    }

    @PostMapping
    public ProductResultDto saveProduct(ProductResultDto product) {
        return restTemplate.postForObject(
                "http://localhost:8080/product",
                product, ProductResultDto.class);
    }

}