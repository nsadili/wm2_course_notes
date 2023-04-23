package az.edu.ada.wm2.springbootsecurityframeworkdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public String welcomeMessage(){
        return "Welcome to building B";
    }

    @Bean
    public String farewellMessage(){
        return "Bye, friend! That was nice seeing you...";
    }
}
