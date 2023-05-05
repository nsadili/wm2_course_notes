package az.edu.ada.wm2.springbootsecurityframeworkdemo.init;

<<<<<<< HEAD
import az.edu.ada.wm2.springbootsecurityframeworkdemo.model.entity.User;
import az.edu.ada.wm2.springbootsecurityframeworkdemo.repo.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
=======
import az.edu.ada.wm2.springbootsecurityframeworkdemo.entity.User;
import az.edu.ada.wm2.springbootsecurityframeworkdemo.repo.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
>>>>>>> e34632cbb6be8e37891d993fc95f4a181e066e39
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbUsersBootstrapper {

    @Bean
    public ApplicationRunner init(UserRepository userRepo, PasswordEncoder encoder) {
        return (args) -> {
            User adminUser = new User("admin", encoder.encode("admin"), "admin_user@ada.edu.az");
<<<<<<< HEAD
            userRepo.save(adminUser.addRole("ROLE_ADMIN"));
=======
//            userRepo.save(adminUser.addRole(new SimpleGrantedAuthority("ROLE_ADMIN")));
>>>>>>> e34632cbb6be8e37891d993fc95f4a181e066e39

            userRepo.save(new User("nsadili", encoder.encode("12345"), "nsadili@ada.edu.az"));
        };
    }

}
