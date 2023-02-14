package az.edu.ada.wm2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("test");
	}

	@RequestMapping("/")
	public String getInfo()
	{
		return "Hello World";
	}
	/*@Bean
	public String myBean(){
		return "Nuraddin";
	}*/
}
