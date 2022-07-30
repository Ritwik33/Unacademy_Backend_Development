package com.unacademy.cartService;

import com.unacademy.cartService.daos.CustomerDao;
import com.unacademy.cartService.daos.ItemDao;
import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.exceptions.*;
import com.unacademy.cartService.services.Impl.CartServiceImpl;
import com.unacademy.cartService.services.Impl.ItemServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(CartServiceApplication.class, args);

	}

}
