package az.edu.ada.wm2.resfuldemo.service.impl;

import az.edu.ada.wm2.resfuldemo.model.entity.Product;
import az.edu.ada.wm2.resfuldemo.repo.ProductRepository;
import az.edu.ada.wm2.resfuldemo.service.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository prodRepo;

    public ProductServiceImpl(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    @Override
    public Product save(Product p) {
        return prodRepo.save(p);
    }

    @Override
    public void deleteById(Long id) {
        prodRepo.deleteById(id);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return prodRepo.findById(id);
    }

    @Override
    public Optional<Product> update(Long id, Product p) {
        Optional<Product> older = prodRepo.findById(id);
        if (older.isEmpty()) return Optional.empty();

        p.setId(id);

        return Optional.of(prodRepo.save(p));
    }

    @Override
    public List<Product> list() {
        return prodRepo.findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"));
    }

    @Override
    public Optional<Product> partialUpdate(Long id, Map<String, Object> p) {
        return Optional.empty();
    }
}
