package az.edu.ada.wm2.yourfirstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class YourFirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourFirstSpringAppApplication.class, args);
	}
}
	@RequestMapping('/')
	public String getInfo(){
		return "Hello World";
	}

}
}

