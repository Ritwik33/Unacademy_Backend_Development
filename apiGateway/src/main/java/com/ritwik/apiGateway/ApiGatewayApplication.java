package com.ritwik.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1. I should get registered to the eureka server
 *
 * 2. Define the routes so that it can start acting as the API Gateways
 *     a. define the routes
 *         decide the logic to make the call to the different services
 *
 *         define the configurations class
 *
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
