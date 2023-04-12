package webII.com.example.Web.II.Project2.init;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import webII.com.example.Web.II.Project2.entity.User;
import webII.com.example.Web.II.Project2.repo.UserRepostitory;

@Component
public class DbUsersBootstrappers {
    @Bean
    public ApplicationRunner init(UserRepostitory userRepo,
                                  PasswordEncoder encoder) {
        return (args) -> {
            User adminUser = new User("admin", encoder.encode("admin"),
                    "smardanli13986@ada.edu.az");

//            userRepo.save(adminUser.addRole(new
//                    SimpleGrantedAuthority("ROLE_ADMIN")));

            userRepo.save(new User("senanm", encoder.encode("12345"),
                    "smardanli13986@ada.edu.az"));
        };
    }
}
