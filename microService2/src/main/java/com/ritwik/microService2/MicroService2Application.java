package com.ritwik.microService2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping(value = "/messages")
@RefreshScope
public class MicroService2Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroService2Application.class, args);
	}

//	@Value("${welcome.message}")
//	private String welcomeMessage;

	@Autowired
	private ServerProperties serverProperties;

	@GetMapping
	public ResponseEntity<String> hello() {
		/**
		 * some identifier for the running instance ...
		 *
		 * The running portNumber
		 */
		System.out.println("The port number is : " + serverProperties.getPort());
		return new ResponseEntity<String>("hello from microservice2", HttpStatus.OK);

	}

}
