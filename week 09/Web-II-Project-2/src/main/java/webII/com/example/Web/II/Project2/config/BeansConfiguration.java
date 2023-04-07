package webII.com.example.Web.II.Project2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public String greetText(){
        return "Hello everyone, welcome!";
    }

    @Bean
    public String byeText(){
        return "Farewell, my dear friend.. :( v";
    }
}
