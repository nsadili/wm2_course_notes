package az.edu.ada.wm2.Usersecurity.init;

import az.edu.ada.wm2.Usersecurity.entity.User;
import az.edu.ada.wm2.Usersecurity.repo.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class DbUserBootsrapper {
    @Bean
    public ApplicationRunner init(UserRepository userRepo,
                                  PasswordEncoder encoder) {
        return (args) -> {
            User adminUser = new User("admin", encoder.encode("admin"),
                    "nsadili@ada.edu.az");
            userRepo.save(adminUser.addRole(new
                    SimpleGrantedAuthority("ROLE_ADMIN")));
            userRepo.save(new User("nsadili", encoder.encode("12345"),
                    "nsadili@ada.edu.az"));
        };
    }
}
