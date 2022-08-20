package com.unacademy.cartService.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {

    @JsonProperty(value = "customer_id")
    private int customerId;

    @JsonProperty(value = "customer_name")
    private String customerName;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerName='" + customerName + '\'' +
                '}';
    }

}
