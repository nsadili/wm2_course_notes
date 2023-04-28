package az.edu.ada.wm2.Usersecurity.config;

import az.edu.ada.wm2.Usersecurity.entity.User;
import az.edu.ada.wm2.Usersecurity.repo.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import java.util.*;

@Configuration
public class SecurityConfig {

    @Value("${spring.h2.console.path}")
    private String h2Console;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*@Bean
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
    }*/

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .requestMatchers("/users/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/admins/**").hasRole("ADMIN")
                .requestMatchers(PathRequest.toH2Console()).permitAll() //tbd
                .anyRequest().authenticated()
                .and()
                .formLogin()
        ;

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            Optional<User> userOpt = userRepo.findByUsername(username);
            return userOpt.orElseThrow(() ->
                    new UsernameNotFoundException(
                            String.format("User %s not found!", username)));
        };
    }

}
