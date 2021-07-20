package com.example.demo;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcDemoApplication implements CommandLineRunner {

    @Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User(1, "Walter", "White", "Teacher", 50));
		userRepository.save(new User(2, "Jesse", "Pinkman", "Student", 26));
		userRepository.save(new User(3, "Gustavo", "Fring", "Restaurant Owner", 48));

	}
}
