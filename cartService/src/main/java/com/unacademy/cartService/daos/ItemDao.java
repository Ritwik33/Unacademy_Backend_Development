package com.unacademy.cartService.daos;

import com.unacademy.cartService.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Integer> {

}
