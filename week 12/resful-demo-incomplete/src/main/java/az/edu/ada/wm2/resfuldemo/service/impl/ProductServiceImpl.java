package az.edu.ada.wm2.resfuldemo.service.impl;

import az.edu.ada.wm2.resfuldemo.model.dto.ProductDTO;
import az.edu.ada.wm2.resfuldemo.model.entity.Product;
import az.edu.ada.wm2.resfuldemo.model.mapper.ProductMapper;
import az.edu.ada.wm2.resfuldemo.repo.ProductRepository;
import az.edu.ada.wm2.resfuldemo.service.ProductService;
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
    public List<ProductDTO> list() {
       var prods = prodRepo.findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"));

       return ProductMapper.INSTANCE.productListToProductDTOList(prods);
//
//       return prods.stream().map(product -> new ProductDTO(
//               product.getId(), product.getName(),
//               product.getDescription(), product.getPricePerItem()
//       )).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> partialUpdate(Long id, Map<String, Object> map) {
        Optional<Product> oldPro =  prodRepo.findById(id);

        if(oldPro.isEmpty())
            return Optional.empty();

        Product pr = oldPro.get();
        map.forEach((fieldName, value)->{
            Field field = ReflectionUtils.findField(Product.class, fieldName);
            field.setAccessible(true);
            try {
                field.set(pr, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        return Optional.of(prodRepo.save(pr));
    }
}
