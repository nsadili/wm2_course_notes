package com.example.rest_consumer.controller;

import com.example.rest_consumer.model.Product;
import controller.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Product> listProducts() {
        String url = "http://localhost:8080/products";
        ResponseEntity<Product[]> response = restTemplate.getForEntity(url, Product[].class);
        Product[] products = response.getBody();
        return Arrays.asList(products);
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") Long id) {
        String url = "http://localhost:8080/products/" + id;
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
        return response.getBody();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        String url = "http://localhost:8080/products";
        ResponseEntity<Product> response = restTemplate.postForEntity(url, product, Product.class);
        return response.getBody();
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") Long id, @RequestBody Product newP) {
        String url = "http://localhost:8080/products/" + id;
        restTemplate.put(url, newP);
        return newP;
    }

    @DeleteMapping("/{productId}")
    public void removeById(@PathVariable("productId") Long id) {
        String url = "http://localhost:8080/products/" + id;
        restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
    }
}
