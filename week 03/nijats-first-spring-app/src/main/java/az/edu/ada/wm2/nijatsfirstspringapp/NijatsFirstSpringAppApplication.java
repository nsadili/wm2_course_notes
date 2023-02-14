package az.edu.ada.wm2.nijatsfirstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class NijatsFirstSpringAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(NijatsFirstSpringAppApplication.class, args);
		System.out.println("Printing your HELLO WORLD");
	}
	@RequestMapping("/")
	public List<String> getInfo(){
		return List.of("Nijat", "Mahir", "Jamal");
	}
}
