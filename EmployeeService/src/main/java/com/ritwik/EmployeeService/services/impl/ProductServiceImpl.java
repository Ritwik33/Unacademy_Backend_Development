package com.ritwik.EmployeeService.services.impl;

import com.ritwik.EmployeeService.daos.impl.ProductDaoImpl;
import com.ritwik.EmployeeService.entities.Product;
import com.ritwik.EmployeeService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDaoImpl productDao;

    @Override
    public Product getProductById(int productId) {

        try {
            Thread.sleep(1000*7);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return productDao.getProductDetails(productId);

    }

    @Override
    public List<Product> getAllProducts() {

        try {
            Thread.sleep(1000*7);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return productDao.getAllProducts();

    }

    @Override
    public Product saveProductDetails(Product product) {

        productDao.saveProductDetails(product);
        return product;

    }
}
