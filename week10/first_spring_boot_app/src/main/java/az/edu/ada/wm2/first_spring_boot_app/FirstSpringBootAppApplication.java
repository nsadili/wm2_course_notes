package az.edu.ada.wm2.first_spring_boot_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class FirstSpringBootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringBootAppApplication.class, args);
    }

}
