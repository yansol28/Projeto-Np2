package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "Projeto NP2 de Tópicos de Desenv. Web",
	        version = "1.0",
	        description = "Documentação de API construída em sala",
	        contact = @Contact(
	        	    name = "Yan Sol",
	        	    email = "yantcha2@gmail.com",
	        	     url = "https://unichristus.edu.br")
	    )
	)


public class SwaggerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerConfigApplication.class, args);
	}

}

