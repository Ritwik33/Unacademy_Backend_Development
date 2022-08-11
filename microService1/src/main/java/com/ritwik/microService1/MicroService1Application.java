package com.ritwik.microService1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. I want to create a service -> REST Endpoints
 *
 *   GET 127.0.0.1:7071/ms1/v1/messages
 *
 * 2. I want to auto register with Eureka Server
 *
 */

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping(value = "/messages")
public class MicroService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}

	@GetMapping
	public ResponseEntity<String> helloMessage() {
		return new ResponseEntity<String>("Hello from Microservice1", HttpStatus.OK);
	}

}
