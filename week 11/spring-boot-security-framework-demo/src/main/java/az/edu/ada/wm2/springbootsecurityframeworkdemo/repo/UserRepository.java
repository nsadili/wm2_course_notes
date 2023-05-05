package az.edu.ada.wm2.springbootsecurityframeworkdemo.repo;

<<<<<<< HEAD
import az.edu.ada.wm2.springbootsecurityframeworkdemo.model.entity.User;
=======
import az.edu.ada.wm2.springbootsecurityframeworkdemo.entity.User;
>>>>>>> e34632cbb6be8e37891d993fc95f4a181e066e39
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
