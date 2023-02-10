package az.edu.ada.wm2.myfirstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyFirstSpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringAppApplication.class, args);

        System.out.println("Printing your HELLO WORLD");
    }

    @RequestMapping("/")
    public String getInfo() {
        return "Hello World";
    }
}
