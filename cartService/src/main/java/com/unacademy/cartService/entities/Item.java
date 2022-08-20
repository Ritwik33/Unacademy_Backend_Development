package com.unacademy.cartService.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(name = "item_desc",length = 512)
    private String itemDescription;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private double cost;

    @Column(name = "mfg_date", nullable = false)
    private LocalDate manufacturingDate;

    @ManyToMany(mappedBy = "items")
    private List<Cart> carts;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", manufacturingDate=" + manufacturingDate +
                '}';
    }
}
