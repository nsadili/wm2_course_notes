package az.edu.ada.wm2.springbootsecurityframeworkdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/static").setViewName("static");
<<<<<<< HEAD
        registry.addViewController("/login").setViewName("login");
=======
>>>>>>> e34632cbb6be8e37891d993fc95f4a181e066e39
    }
}
