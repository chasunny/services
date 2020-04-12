package com.food.ordermanagement;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableCircuitBreaker
@EnableFeignClients("com.food.ordermanagement")
public class OrdermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermanagementApplication.class, args);
	}

	@Bean
	public Docket SwaggerConfiguration(){
		
		return new Docket(DocumentationType.SWAGGER_2)
				   .select()
				   .paths(PathSelectors.any())
				   .apis(RequestHandlerSelectors.basePackage("com.food.ordermanagement"))
				   .build()
		           .apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("food application",
				            "order management", 
				            "1.1", "free to use",
				            new springfox.documentation.service.Contact("charan teja","https://localhost:8083","codechef@gmail.com"),
				            "API license",
				            "https://localhost:8083",
				             Collections.emptyList());
	}
}
