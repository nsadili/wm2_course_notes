package az.edu.ada.wm2.demoForRest.client.controller;

import az.edu.ada.wm2.demoForRest.client.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/")
public class RestClientController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public ResponseDto[] getAllProducts(){
        var res = restTemplate.getForEntity(
                url="http://localhost:8080/api/v1/products",
                ResponseDto[].class);

        if(res.getStatusCode() == HttpStatus.OK)
        {
            var arr = res.getBody();
            return arr;
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseDto getProductsById(@PathVariable Integer id){
        var resProduct = restTemplate.getForObject("http://localhost:8080/api/v1/products/{id}",
                ResponseDto.class,
                Map.of("id", id));
        return resProduct;
    }
}
