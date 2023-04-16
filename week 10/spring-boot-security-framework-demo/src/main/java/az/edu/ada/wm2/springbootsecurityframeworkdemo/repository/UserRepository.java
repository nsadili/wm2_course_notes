package az.edu.ada.wm2.springbootsecurityframeworkdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import az.edu.ada.wm2.springbootsecurityframeworkdemo.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
