package com.ritwik.EmployeeService.services;

import com.ritwik.EmployeeService.entities.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(int productId);
    List<Product> getAllProducts();
    Product saveProductDetails(Product product);

}
