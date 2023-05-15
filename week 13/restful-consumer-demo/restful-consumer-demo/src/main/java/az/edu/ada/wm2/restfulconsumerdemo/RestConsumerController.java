package az.edu.ada.wm2.restfulconsumerdemo;

import az.edu.ada.wm2.restfulconsumerdemo.dto.ProductResultDto;
import org.springframework.beans.factory.annotation.Autowired;
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


      @Autowired
      private RestTemplate restTemplate;

          @GetMapping
          public void getAllProducts() {

           ResponseEntity<ProductResultDto[]> res = restTemplate.getForEntity(
                   "http://localhost:8080/api/v1/products",
                    ProductResultDto[].class);

            var products = res.getBody();

            return products;
          }

          @GetMapping("/{id}")
          public ProductResultDto getProductId(@PathVariable Integer productId){
//              var params = new HashMap<>();
//              params.put("id", productId);

             var product =  restTemplate.getForObject(
                      "http://localhost:8080/api/v1/products/{id}",
                      ProductResultDto.class,
                      Map.of("id", productId)
              );

              return product == null;


          }
      }
