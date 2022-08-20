package com.ritwik.EmployeeService.daos.impl;

import com.ritwik.EmployeeService.daos.ProductDao;
import com.ritwik.EmployeeService.entities.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ProductDaoImpl implements ProductDao {

    private static HashMap<Integer, Product> productData = new HashMap<>();

    @PostConstruct
    private void fillProducts() {

        productData.put(1, new Product(1, "Charger", 2000));
        productData.put(2, new Product(2, "Phone", 20000));
        productData.put(3, new Product(3, "Pen", 20));
        productData.put(4, new Product(4, "Notebook", 200));
        productData.put(5, new Product(5, "Bottle", 150));

    }

    @Override
    public Product getProductDetails(int productId) {

        return productData.get(productId);

    }

    @Override
    public List<Product> getAllProducts() {

        Collection<Product> productCollection = productData.values();
        Iterator<Product> productIterator = productCollection.iterator();
        List<Product> products = new ArrayList<>();
        while(productIterator.hasNext()) {
            products.add(productIterator.next());
        }
        return products;

    }

    @Override
    public Product saveProductDetails(Product product) {

        productData.put(product.getProductId(), product);
        return product;

    }
}
