package az.edu.ada.wm2.springbootsecurityframeworkdemo.Repository;

import az.edu.ada.wm2.springbootsecurityframeworkdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsername(String username);

}
