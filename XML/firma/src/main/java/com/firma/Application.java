package com.firma;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.firma.repository.FirmaRepository;

@EnableJpaRepositories(basePackageClasses=FirmaRepository.class)
@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan
//@EnableAutoConfiguration

//@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
