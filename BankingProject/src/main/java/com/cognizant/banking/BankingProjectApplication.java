package com.cognizant.banking;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cognizant.*")
@EntityScan(basePackages = "com.cognizant.banking.entities")
@EnableJpaRepositories(basePackages = "com.cognizant.banking.repositories")

public class BankingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingProjectApplication.class, args);
	}

}
