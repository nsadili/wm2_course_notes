package az.edu.ada.wm2.resfuldemo.init;

import az.edu.ada.wm2.resfuldemo.model.entity.Product;
import az.edu.ada.wm2.resfuldemo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer {


    @Bean
    @Autowired
    public CommandLineRunner init(ProductRepository productRepo) {
        return (args) -> {
            Product p1 = productRepo.save(new Product("test", "test 12345", 123.0));
            Product p2 = productRepo.save(new Product("abc", "abc 12345", 234.0));

            Thread.sleep(1000 * 60);

            productRepo.save(new Product("latest", "latest product created", 169.0));

            Thread.sleep(1000 * 90);

            p1.setPricePerItem(50.0);
            p2.setPricePerItem(p2.getPricePerItem() * 2);

            productRepo.save(p1);
            productRepo.save(p2);
        };
    }

}
