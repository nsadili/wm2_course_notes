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

<<<<<<< HEAD
=======

>>>>>>> e34632cbb6be8e37891d993fc95f4a181e066e39
@SpringBootApplication
public class YourFirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourFirstSpringAppApplication.class, args);

		System.out.println("Printing your HELLO WORLD!");
	}



@SpringBootApplication
public class YourFirstSpringAppApplication {

	public static void main(String[] args) {
<<<<<<< HEAD


public class YourFirstSpringAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(YourFirstSpringAppApplication.class, args);

		System.out.println("Printing your HELLO WORLD!");



@SpringBootApplication
public class YourFirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourFirstSpringAppApplication.class, args);

		System.out.println("Printing your HELLO WORLD!");
	}

=======
		SpringApplication.run(YourFirstSpringAppApplication.class, args);

		System.out.println("Printing your HELLO WORLD!");
>>>>>>> e34632cbb6be8e37891d993fc95f4a181e066e39
	}



}


<<<<<<< HEAD
=======
}

}


>>>>>>> e34632cbb6be8e37891d993fc95f4a181e066e39
