package com.firma.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.firma.controllers.NalogZaPrenosController;


@Configuration
public class ApplicationConfiguration {

	@Bean
	public NalogZaPrenosController nalogzaprenosController() {
		return new NalogZaPrenosController();
	}
}
