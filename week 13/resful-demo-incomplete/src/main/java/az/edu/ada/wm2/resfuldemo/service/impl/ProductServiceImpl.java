package az.edu.ada.wm2.resfuldemo.service.impl;

import az.edu.ada.wm2.resfuldemo.model.dto.ProductDto;
import az.edu.ada.wm2.resfuldemo.model.entity.Product;
import az.edu.ada.wm2.resfuldemo.model.mapper.ProductMapper;
import az.edu.ada.wm2.resfuldemo.repo.ProductRepository;
import az.edu.ada.wm2.resfuldemo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

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
    public List<ProductDto> list() {
        var prods = prodRepo.findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"));

//        return prods.stream().map(prod -> new ProductDto(
//                prod.getId(), prod.getName(),
//                prod.getDescription(), prod.getPricePerItem()
//        )).collect(Collectors.toList());

        return ProductMapper.INSTANCE.productListToProductDtoList(prods);
    }

    @Override
    public Optional<Product> partialUpdate(Long id, Map<String, Object> map) {
        Optional<Product> oldProd = prodRepo.findById(id);

        if (oldProd.isEmpty()) return oldProd;

        Product pr = oldProd.get();
        map.forEach((fieldName, value) -> {
            try {
                Field field = ReflectionUtils.findField(Product.class, fieldName);
                field.setAccessible(true);
                field.set(pr, value);
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        });

        return Optional.of(prodRepo.save(pr));
    }
}
