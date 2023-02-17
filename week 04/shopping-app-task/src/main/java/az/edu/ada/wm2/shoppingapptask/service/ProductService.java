package az.edu.ada.wm2.shoppingapptask.service;

import az.edu.ada.wm2.shoppingapptask.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> list();

    Product getById(String id);

    Product save(Product product);

    void deleteById(String id);
}