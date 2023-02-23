package az.edu.ada.wm2.myfirstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MyFirstSpringAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyFirstSpringAppApplication.class, args);

		System.out.println("Hello Earth!");
	}

	@RequestMapping("/")
	public List<String> getInfo(){
		return List.of("Niko", "Atakhan", "Mika");
	}
}
