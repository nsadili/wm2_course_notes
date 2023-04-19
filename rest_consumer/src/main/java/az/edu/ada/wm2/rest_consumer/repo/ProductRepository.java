package az.edu.ada.wm2.rest_consumer.repo;

import az.edu.ada.wm2.rest_consumer.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
