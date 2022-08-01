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
            new Customer("Rishi Chatterjee"),
            new Customer("Ramashish Chatterjee"),
            new Customer("Payal Chatterjee"),
            new Customer("Mayank Kumar"),
            new Customer("Manas Mandal"),
            new Customer("Ritesh Sharma"),
            new Customer("Ritwik Chatterjee")
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
        item1.setItemName("shilajit");
        item1.setItemDescription("boosts testesterone");
        item1.setCost(1400);
        item1.setCategory("HealthCare");
        item1.setManufacturingDate(LocalDate.of(2022, 8, 01));

        item2.setItemName("Ashwagandha");
        item2.setItemDescription("for stress relief, muscle strength and vitality");
        item2.setCost(599);
        item2.setCategory("HealthCare");
        item2.setManufacturingDate(LocalDate.of(2022, 5, 14));

        item3.setItemName("Gokshura");
        item3.setItemDescription("Vitality booster and promotes muscle gain");
        item3.setCost(399);
        item3.setCategory("HealthCare");
        item3.setManufacturingDate(LocalDate.of(2022, 6, 14));

        item4.setItemName("Shatavari");
        item4.setItemDescription("boosts immunity");
        item4.setCost(800);
        item4.setCategory("HealthCare");
        item4.setManufacturingDate(LocalDate.of(2022, 1, 15));

        item5.setItemName("Becosules Capsules");
        item5.setItemDescription("Vitamin B complex + vitamin C");
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
        item10.setCategory("Phones and Computers");
        item10.setManufacturingDate(LocalDate.of(2022, 5, 14));

        itemService.createMultipleItems(items);
    }

    private void createCustomers() {
        customerService.createMultipleCustomers(customers);
    }
}
