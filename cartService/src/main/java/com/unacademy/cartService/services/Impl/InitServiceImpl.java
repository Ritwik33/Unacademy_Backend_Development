package com.unacademy.cartService.services.Impl;

import com.unacademy.cartService.entities.Cart;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.entities.Item;
import com.unacademy.cartService.services.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private ItemServiceImpl itemService;

    List<Customer> customers = Arrays.asList(
            new Customer("Ritwik Chatterjee"),
            new Customer("Aniket Kumar"),
            new Customer("Abhishek Anand"),
            new Customer("kumar Monty Prakash"),
            new Customer("Mayank Kumar"),
            new Customer("Ayush Tripathi"),
            new Customer("Harsh Singh"),
            new Customer("Dhananjay Jaiswal")
    );

    Item item1 = new Item();
    Item item2 = new Item();
    Item item3 = new Item();
    Item item4 = new Item();
    Item item5 = new Item();
    Item item6 = new Item();
    Item item7 = new Item();
    Item item8 = new Item();
    Item item9 = new Item();
    Item item10 = new Item();

    List<Item> items = Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10);

    List<Cart> carts = Arrays.asList(
            new Cart(customers.get(0), List.of(item1, item2, item3, item4)),
            new Cart(customers.get(1), List.of(item4, item5)),
            new Cart(customers.get(2), List.of(item6, item9, item10)),
            new Cart(customers.get(3), List.of(item3, item7, item8)),
            new Cart(customers.get(4), List.of(item6, item7, item4)),
            new Cart(customers.get(5), List.of(item1, item7, item10, item4)),
            new Cart(customers.get(6), List.of(item2, item6, item8))
    );

    @Override
    public void init() {

        createCustomers();

        createItems();

        createCarts();

    }

    private void createCarts() {
        cartService.createMultipleCarts(carts);
    }

    private void createItems() {
        item1.setItemName("Duffle Bag");
        item1.setItemDescription("A must have for gym freaks");
        item1.setCost(1500);
        item1.setCategory("Luggage");
        item1.setManufacturingDate(LocalDate.of(2022, 8, 01));

        item2.setItemName("Park Avenue Deo");
        item2.setItemDescription("Awesome fragrance, creates an Aura");
        item2.setCost(450);
        item2.setCategory("Perfumes and Deodorants");
        item2.setManufacturingDate(LocalDate.of(2022, 5, 14));

        item3.setItemName("Muscle Blaze Whey Isolate");
        item3.setItemDescription("25gms of protein in a single scoop of protein, Improved muscle recovery");
        item3.setCost(4500);
        item3.setCategory("Foods and Beverages");
        item3.setManufacturingDate(LocalDate.of(2022, 6, 14));

        item4.setItemName("Boat Earbuds");
        item4.setItemDescription("Awesome sound quality");
        item4.setCost(2500);
        item4.setCategory("Electronics");
        item4.setManufacturingDate(LocalDate.of(2022, 1, 15));

        item5.setItemName("Neurobion Forte");
        item5.setItemDescription("Vitamin B complex + vitamin C supplement");
        item5.setCost(46);
        item5.setCategory("HealthCare");
        item5.setManufacturingDate(LocalDate.of(2022, 3, 26));

        item6.setItemName("t-shirt");
        item6.setItemDescription("very comfortable and light");
        item6.setCost(500);
        item6.setCategory("clothing");
        item6.setManufacturingDate(LocalDate.of(2022, 8, 01));

        item7.setItemName("trousers");
        item7.setItemDescription("very comfortable");
        item7.setCost(1599);
        item7.setCategory("clothing");
        item7.setManufacturingDate(LocalDate.of(2022, 8, 01));

        item8.setItemName("Nachos");
        item8.setItemDescription("Pair it up with salsa");
        item8.setCost(500);
        item8.setCategory("Foods and beverages");
        item8.setManufacturingDate(LocalDate.of(2022, 8, 14));

        item9.setItemName("Pepsi");
        item9.setItemDescription("refreshing drink");
        item9.setCost(85);
        item9.setCategory("Foods and beverages");
        item9.setManufacturingDate(LocalDate.of(2022, 8, 16));

        item10.setItemName("Oneplus Nord CE 2 5G");
        item10.setItemDescription("cost : 24999 \n camera : 64mp + 8mp + 2mp \n storage : 128gb + 8gb \n " +
                "Processor : Dimensity 900 Octa-Core \n Os : OxygenOS Version V11.3 \n model : IV2201");
        item10.setCost(24999);
        item10.setCategory("Electronics");
        item10.setManufacturingDate(LocalDate.of(2022, 5, 14));

        itemService.createMultipleItems(items);
    }

    private void createCustomers() {
        customerService.createMultipleCustomers(customers);
    }
}
