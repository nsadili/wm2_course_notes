package az.edu.az.wm2.mongo_db_demo.service;

import az.edu.az.wm2.mongo_db_demo.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ExternalService {

    private final String BASE_URI = "https://jsonplaceholder.typicode.com";

    @Autowired
    WebClient.Builder webClientBuilder;

    public List<UserData> getAllUserDateFromApi() {
        return webClientBuilder.build()
                .get()
                .uri(BASE_URI + "/users")
                .retrieve()
                .bodyToFlux(UserData.class)
                .collectList().block();
    }

    public UserData getUserById(Long id) {
        return webClientBuilder.build()
                .get()
                .uri(BASE_URI + "/users/" + id)
                .retrieve()
                .bodyToMono(UserData.class)
                .block();
    }
}
