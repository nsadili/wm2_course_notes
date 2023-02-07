package az.edu.ada.wm2.myfirstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyFirstSpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringAppApplication.class, args);
    }

    @Bean
    public String myBean() {
        return "Toghrul";
    }

    @RequestMapping()
    public String user() {

    }
}
