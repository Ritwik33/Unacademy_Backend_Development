package com.unacademy.cartService.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ItemDTO {

    @JsonProperty(value = "item_id")
    private int itemId;

    @JsonProperty(value = "item_name")
    private String itemName;

    @JsonProperty(value = "item_desc")
    private String itemDescription;

    private String category;

    private double cost;

    @JsonProperty(value = "mfg_date")
    private LocalDate manufacturingDate;

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
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", manufacturingDate=" + manufacturingDate +
                '}';
    }
}
