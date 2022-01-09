package com.springboot.customerbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Bank Customer API", version = "2.0", description = "Spring Boot Application Named Customer Bank"))
public class CustomerBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerBankApplication.class, args);
	}

}
