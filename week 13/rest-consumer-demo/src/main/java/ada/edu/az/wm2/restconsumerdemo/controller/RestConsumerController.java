package ada.edu.az.wm2.restconsumerdemo.controller;


import ada.edu.az.wm2.restconsumerdemo.dto.ProductResultDto;
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
public class RestConsumerController {

    private RestTemplate restTemplate = new RestTemplate();
    @GetMapping
    public ProductResultDto[] getAllProducts(){
        ResponseEntity<ProductResultDto[]> res = restTemplate.getForEntity(
                "http://localhost:8080/api/v1/products",
                ProductResultDto[].class
        );


        var products = res.getBody();

        return products;
    }
    @GetMapping("/{id}")
    public ProductResultDto getProductById(@PathVariable ("id") Integer productId){

        /*var params = new HashMap<>();
        params.put("id", productId);*/

        var product = restTemplate.getForObject("http://localhost:8080/api/v1/products/{id}/",
                ProductResultDto.class,
                //params
                Map.of("id", productId)

        );
        //System.out.println(product);

        return  product == null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok();

        return product;
    }
}
