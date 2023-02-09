package az.edu.ada.wm2.yourfirstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class YourFirstSpringAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourFirstSpringAppApplication.class, args);

        System.out.println("Printing your HELLO WORLD!");
    }

    @RequestMapping("/")
    public List<String> getInfo(){
        return List.of("Nuraddin", "Mahir", "Jamal");
    }

}

@SpringBootApplication
public class YourFirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourFirstSpringAppApplication.class, args);

		System.out.println("Printing your HELLO WORLD!");
	}

}


