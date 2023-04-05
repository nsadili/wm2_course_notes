package az.edu.ada.wm2.Usersecurity.config;

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
import org.w3c.dom.stylesheets.LinkStyle;

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
    public UserDetailsService userDetailsService (PasswordEncoder passwordEncoder){
        List<UserDetails> users = new ArrayList<>();
        Collections.addAll(users,
                new User(
                        "nsadili", passwordEncoder.encode("12345"),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))),
                new User(
                        "admin", passwordEncoder.encode("admin"),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .requestMatchers("/users/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/admins/**").hasRole("ADMIN")
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
        ;

        return http.build();
    }
}
