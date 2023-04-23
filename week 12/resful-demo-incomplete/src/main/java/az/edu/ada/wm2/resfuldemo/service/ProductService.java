package az.edu.ada.wm2.resfuldemo.service;

import az.edu.ada.wm2.resfuldemo.model.dto.ProductDTO;
import az.edu.ada.wm2.resfuldemo.model.entity.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

    Product save(Product p);

    void deleteById(Long id);

    Optional<Product> getById(Long id);

    Optional<Product> update(Long id, Product p);

    Optional<Product> partialUpdate(Long id, Map<String, Object> p);

    List<ProductDTO> list();
}
