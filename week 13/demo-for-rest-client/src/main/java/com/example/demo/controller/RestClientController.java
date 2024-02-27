package com.example.demo.controller;

import com.example.demo.dto.ResProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class RestClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResProductDto[] getAllProducts() {
        ResponseEntity<ResProductDto[]> res = restTemplate.getForEntity(
                "http://localhost:8080/api/v1/products",
                ResProductDto[].class
        );

        if (res.getStatusCode() == HttpStatus.OK) {
            var arr = res.getBody();
            return arr;
        }

        return null;
    }

    @GetMapping("/{id}")
    public ResProductDto getProducById(@PathVariable Integer id) {
//        var params = new HashMap<>();
//        params.put("id", id);
        var resProduct = restTemplate.getForObject(
                "http://localhost:8080/api/v1/products/{id}",
                ResProductDto.class,
                Map.of("id", id)
        );

        return resProduct;
    }

}
