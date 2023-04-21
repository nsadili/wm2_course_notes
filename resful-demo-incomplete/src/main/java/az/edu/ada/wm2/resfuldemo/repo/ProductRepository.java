package az.edu.ada.wm2.resfuldemo.repo;

import az.edu.ada.wm2.resfuldemo.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
