package az.edu.ada.wm2.springbootsecurityframeworkdemo.repo;

import az.edu.ada.wm2.springbootsecurityframeworkdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
   Optional<User> findByUsername(String username);

}
