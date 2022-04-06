package az.edu.ada.wm2.first_spring_boot_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class VariableConfig {

//    @Bean("farewellText")
    public String getFarewellText(){
        return "Bye, friends!";
    }
}
