package az.edu.ada.wm2.myfirstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyFirstSpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringAppApplication.class, args);
    }

    @Bean
    public String myBean() {
        return "Toghrul";
    }

    @RequestMapping("/api/users/{id}")
    public String user(@PathVariable final long id) {
        return "User with id " + id;
    }
}
