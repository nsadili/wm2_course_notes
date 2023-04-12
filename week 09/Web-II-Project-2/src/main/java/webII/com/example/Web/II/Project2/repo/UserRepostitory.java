package webII.com.example.Web.II.Project2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import webII.com.example.Web.II.Project2.entity.User;

import java.util.Optional;

public interface UserRepostitory extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
