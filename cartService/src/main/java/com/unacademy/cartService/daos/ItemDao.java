package com.unacademy.cartService.daos;

import com.unacademy.cartService.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ItemDao extends JpaRepository<Item, Integer> {

    public Item findByItemName(String itemName);

    public List<Item> findByCategory(String category);

    public List<Item> findByCost(double cost);

    public List<Item> findByManufacturingDate(LocalDate mfgDate);

}
