package az.edu.ada.wm2.shoppingapptask.service;

import az.edu.ada.wm2.shoppingapptask.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    static final List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(UUID.randomUUID().toString(), "Apple", "50","2000"));
        products.add(new Product(UUID.randomUUID().toString(), "Samsung","40","199"));
        products.add(new Product(UUID.randomUUID().toString(), "Nokia", "44","555"));
    }

    @Override
    public List<Product> list() {
        return products;
    }

    @Override
    public Product getById(String id) {
        Optional<Product> result = products.stream()
                .filter(product -> product.getId().equals(id))
                .findAny();
        return result.orElse(new Product());
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(UUID.randomUUID().toString());
            products.add(product);

            return product;
        }


        Optional<Product> result = products.stream()
                .filter(p -> p.getId().equals(product.getId()))
                .findAny();

        Product oldRecord = result.orElseThrow();

        oldRecord.setName(product.getName());
        oldRecord.setPrice(product.getPrice());
        oldRecord.setWeight(product.getWeight());


        return oldRecord;
    }

    @Override
    public void deleteById(String id) {
        Optional<Product> result = products.stream()
                .filter(product -> product.getId().equals(id))
                .findAny();

        if (result.isPresent())
            products.remove(result.get());
    }


}