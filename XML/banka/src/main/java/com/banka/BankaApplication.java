package com.banka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.banka.repository.BankaRepository;

@SpringBootApplication
@ComponentScan("com.banka.controllers")
@EnableJpaRepositories(basePackageClasses = BankaRepository.class)
@EnableAutoConfiguration
public class BankaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankaApplication.class, args);
	}
}
