package com.unacademy.cartService.daos;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart, Integer> {

    public Cart findByCustomer(Customer customer);

}
