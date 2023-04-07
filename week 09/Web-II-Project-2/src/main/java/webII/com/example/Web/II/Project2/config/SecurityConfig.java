package webII.com.example.Web.II.Project2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        List<UserDetails> users = new ArrayList<>();

        Collections.addAll(users,
        new User("admin",passwordEncoder.encode("admin"), Arrays.asList(
                new SimpleGrantedAuthority("ROLE_ADMIN")
        )),
        new User("senanm",passwordEncoder.encode("12345"), Arrays.asList(
                new SimpleGrantedAuthority("ROLE_USER")
        )));

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/products/**").hasAnyRole("USER","ADMIN")
                .requestMatchers("/bills/**").hasRole("ADMIN")
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();

        return http.build();
    }
}
