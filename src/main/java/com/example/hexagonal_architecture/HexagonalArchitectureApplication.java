package com.example.hexagonal_architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.hexagonal_architecture.infrastructure.controller")
public class HexagonalArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureApplication.class, args);
	}

}
