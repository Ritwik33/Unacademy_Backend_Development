package com.unacademy.cartService;

import com.unacademy.cartService.services.Impl.InitServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(CartServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner init(InitServiceImpl initService) {
		return args -> {
			initService.init();
		};
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
