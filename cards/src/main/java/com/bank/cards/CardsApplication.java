package com.bank.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.bank.cards.dto.CardsContactInfoDto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")

@EnableConfigurationProperties(value ={CardsContactInfoDto.class})
@OpenAPIDefinition(
	info = @Info(
		title = "Loan microservice REST API Documentation",
		description = "Bank Loan microservice API Documentation",
		version = "v1",
		contact = @Contact(
			name = "Suresh Pokhrail",
			email = "pokhrailsures5@gmail.com",
			url = "sureshpokhrail.netlify.com"
		),
		license = @License(
			name = "Apache 2.0",
			url = "sureshpokhrail.netlify.com"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "Bank Loan microservice REST API Documentation",
		url = "sureshpokhrail.netlify.com"
	)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

} 
