package com.example.newProject;

import com.example.newProject.Repositories.UserRepository;
import org.apache.catalina.Store;
import org.apache.catalina.UserDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class NewProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(NewProjectApplication.class, args);

	}

}
