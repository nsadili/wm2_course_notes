package com.example.newProject;

import com.example.newProject.Repositories.UserRepository;
import com.example.newProject.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final UserRepository userRepository;

    public Bootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args){
        User user = new User();
        user.setName("Ali");
        user.setSurname("Ahmadi");
        user.setAge(19L);
        userRepository.save(user);
        System.out.println(userRepository.count());
    }
}
