package com.unacademy.cartService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(CartServiceApplication.class, args);

	}

}
