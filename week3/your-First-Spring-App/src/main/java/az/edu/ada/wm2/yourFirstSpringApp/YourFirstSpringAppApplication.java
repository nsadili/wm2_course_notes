package az.edu.ada.wm2.yourFirstSpringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class YourFirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourFirstSpringAppApplication.class, args);
		System.out.println("Hello hope it works");
	}
@RequestMapping("/")
	public String getInfo(){
		return "Hello SHafa";
}

}
