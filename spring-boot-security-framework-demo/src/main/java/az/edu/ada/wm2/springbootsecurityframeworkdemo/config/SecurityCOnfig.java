package az.edu.ada.wm2.springbootsecurityframeworkdemo.config;

import az.edu.ada.wm2.springbootsecurityframeworkdemo.Repository.UserRepository;
import az.edu.ada.wm2.springbootsecurityframeworkdemo.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.*;

@Configuration
public class SecurityCOnfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        *//*List<UserDetails> users = new ArrayList<>();
        Collections.addAll(users,

        new User("admin", passwordEncoder().encode("admin"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))),

        new User("tangiz", passwordEncoder().encode("2001"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")))
        );

        return new InMemoryUserDetailsManager(users);*//*


    }*/

    @Bean
    public UserDetailsService userDetailsService(UserRepository repo){
        return username -> {
            Optional<User> res = repo.findByUsername(username);

            return res.orElseThrow(() ->
                    new UsernameNotFoundException(username + " not found")
            );
        };

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/users").hasAnyRole("ADMIN","USER")
                .requestMatchers("/admins/**").hasRole("ADMIN")
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
        ;

        return http.build();
    }


}
