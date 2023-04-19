package az.edu.ada.wm2.rest_consumer.model;

import az.edu.ada.wm2.rest_consumer.model.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductClient {

    private final WebClient webClient;

    public ProductClient(@Value("${api.url}") String apiUrl) {
        this.webClient = WebClient.create(apiUrl);
    }

    public Flux<Product> getAllProducts() {
        return webClient.get()
                .uri("/api/products")
                .retrieve()
                .bodyToFlux(Product.class);
    }

    public Mono<Product> getProductById(String id) {
        return webClient.get()
                .uri("/api/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class);
    }

    public Mono<Product> createProduct(Product product) {
        return webClient.post()
                .uri("/api/products")
                .body(Mono.just(product), Product.class)
                .retrieve()
                .bodyToMono(Product.class);
    }

    public Mono<Product> updateProduct(String id, Product product) {
        return webClient.put()
                .uri("/api/products/{id}", id)
                .body(Mono.just(product), Product.class)
                .retrieve()
                .bodyToMono(Product.class);
    }

    public Mono<Void> deleteProduct(String id) {
        return webClient.delete()
                .uri("/api/products/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
