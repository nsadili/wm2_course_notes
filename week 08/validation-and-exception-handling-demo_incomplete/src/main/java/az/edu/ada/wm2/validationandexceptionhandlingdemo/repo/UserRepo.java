package az.edu.ada.wm2.validationandexceptionhandlingdemo.repo;

import az.edu.ada.wm2.validationandexceptionhandlingdemo.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserData, Long> {
}
