package com.unacademy.cartService.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false, unique = true)
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    public Cart() {
    }

    public Cart(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }

}
