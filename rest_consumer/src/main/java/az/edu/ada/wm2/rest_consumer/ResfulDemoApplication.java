package az.edu.ada.wm2.rest_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ResfulDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResfulDemoApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(RestConsumerApplication.class, args);

		APIConsumer apiConsumer = context.getBean(APIConsumer.class);
		apiConsumer.consumeApis();
	}

}
