package az.edu.ada.wm2.Usersecurity.repo;

import az.edu.ada.wm2.Usersecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> FindByUserName(String username);
}
