package com.example.payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	// Registrar uma intância unica de um objeto do tipo RestTemplate
	// Essa instância unica vai ficar disponivel para injetar em outros componentes
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
