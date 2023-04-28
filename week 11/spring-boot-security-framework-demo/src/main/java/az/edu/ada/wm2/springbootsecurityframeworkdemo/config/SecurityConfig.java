package az.edu.ada.wm2.springbootsecurityframeworkdemo.config;

import az.edu.ada.wm2.springbootsecurityframeworkdemo.model.entity.User;
import az.edu.ada.wm2.springbootsecurityframeworkdemo.repo.UserRepository;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;

@Configuration
public class SecurityConfig {

//    @Value("${spring.h2.console.path}")
//    private String h2Console;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//
//        List<UserDetails> users = new ArrayList<>();
//
//        Collections.addAll(users,
//                new User("admin", passwordEncoder().encode("admin"),
//                        Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")
//                        )),
//                new User("nsadili", passwordEncoder().encode("12345"),
//                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")
//                        ))
//        );
//
//        return new InMemoryUserDetailsManager(users);
//    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository repo) {
        return username -> {
            Optional<User> res = repo.findByUsername(username);

            return res.orElseThrow(() ->
                    new UsernameNotFoundException(username + " not found")
            );
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/users/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/admins/**").hasRole("ADMIN")
                .requestMatchers("/", "/signup/**").permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll() //TBD
//                .requestMatchers(h2Console + "/**").permitAll() //TBD
                .anyRequest().authenticated()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll())
        ;

        return http.build();
    }

}
