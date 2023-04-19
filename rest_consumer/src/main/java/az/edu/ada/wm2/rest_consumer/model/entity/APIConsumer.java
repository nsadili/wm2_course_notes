import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class APIConsumer {

    private final WebClient webClient;

    public ApiConsumer(@Value("${api.url}") String apiUrl) {
        this.webClient = WebClient.create(apiUrl);
    }

    public void consumeApis() {
        // Call the APIs using WebClient and handle the response
        // Here's an example:
        webClient.get()
                .uri("/api/some-resource")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> System.out.println("Response: " + response));
    }
}
