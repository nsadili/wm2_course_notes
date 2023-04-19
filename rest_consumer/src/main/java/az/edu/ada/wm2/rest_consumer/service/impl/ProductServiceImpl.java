package az.edu.ada.wm2.rest_consumer.service.impl;

import az.edu.ada.wm2.rest_consumer.model.ProductClient;
import az.edu.ada.wm2.rest_consumer.model.entity.Product;
import az.edu.ada.wm2.rest_consumer.repo.ProductRepository;
import az.edu.ada.wm2.rest_consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
        if (older.isEmpty()) return older;

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

    private ProductClient productClient;

    @Autowired
    public ProductServiceImpl(ProductClient productClient) {
        this.productClient = productClient;
    }


    public Flux<Product> getAllProducts() {
        return productClient.getAllProducts();
    }


    public Mono<Product> getProductById(String id) {
        return productClient.getProductById(id);
    }


    public Mono<Product> createProduct(Product product) {
        return productClient.createProduct(product);
    }


    public Mono<Product> updateProduct(String id, Product product) {
        return productClient.updateProduct(id, product);
    }


    public Mono<Void> deleteProduct(String id) {
        return productClient.deleteProduct(id);
    }
}
