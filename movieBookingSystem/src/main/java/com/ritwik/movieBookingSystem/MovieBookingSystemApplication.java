package com.ritwik.movieBookingSystem;

import com.ritwik.movieBookingSystem.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieBookingSystemApplication {
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

	}

	/**
	 * This is a way to execute something in the very beginning when application is starting up ...
	 * @param initService
	 * @return
	 */

	@Bean
	CommandLineRunner init(InitService initService) {
		return args -> {
			initService.init();
		};
	}

	/**
	 * this will store the manually created object as a bean in the spring container ...
	 * @return
	 */

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
