package com.ritwik.EmployeeService.daos;

import com.ritwik.EmployeeService.entities.Product;

import java.util.List;

public interface ProductDao {

    Product getProductDetails(int productId);
    List<Product> getAllProducts();
    Product saveProductDetails(Product product);

}
