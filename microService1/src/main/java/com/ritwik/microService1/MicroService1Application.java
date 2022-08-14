package com.ritwik.microService1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
@EnableFeignClients
public class MicroService1Application {

	@Autowired
	private MicroService2Client microService2Client;

	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}

	/**
	 * GET localhost:7071/ms1/v1/messages
	 *
	 *          GET localhost:7072/ms2/v1/messages :- Hello from microService2
	 *
	 *     		Hello from microService1 + "Response from MS2" + Hello from microService2
	 *
	 * @return
	 */

	@GetMapping
	public ResponseEntity<String> helloMessage() {
		/**
		 * I should call the microService2
		 * GET localhost:7072/ms2/v1/messages
		 *
		 * Whatever be the result of the above GET call, append to the response ...
		 * @return
		 */

		// call the microService2 - We need some client
		String response = microService2Client.getMessage();
		return new ResponseEntity<String>("Hello from Microservice1" + " Response from MS2 " + response, HttpStatus.OK);
	}

}
