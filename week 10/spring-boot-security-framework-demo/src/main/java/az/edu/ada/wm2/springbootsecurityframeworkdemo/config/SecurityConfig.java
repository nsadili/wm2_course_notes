package az.edu.ada.wm2.springbootsecurityframeworkdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        List<UserDetails> users = new ArrayList<>();
        new User("admin", "password", Arrays.asList(
                new SimpleGrantedAuthority("ROLE_ADMIN")
        ));
        new User("nshirinov", "12345", Arrays.asList(
                new SimpleGrantedAuthority("ROLE_ADMIN")
        ));
        return new InMemoryUserDetailsManager(users);
    }

}
