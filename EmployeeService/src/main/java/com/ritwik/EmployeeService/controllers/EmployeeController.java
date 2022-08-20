package com.ritwik.EmployeeService.controllers;

import com.ritwik.EmployeeService.cacheStores.CacheStore;
import com.ritwik.EmployeeService.entities.Employee;
import com.ritwik.EmployeeService.entities.Product;
import com.ritwik.EmployeeService.services.impl.EmployeeServiceImpl;
import com.ritwik.EmployeeService.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employeeService/v1")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CacheStore<Employee> employeeCache;

    @Autowired
    private CacheStore<Product> productCache;

    @GetMapping(value = "/employees/{employeeId}")
    public ResponseEntity<Employee> searchEmployeeById(@PathVariable(value = "employeeId") int employeeId) {

        Employee cachedEmployee = employeeCache.get(employeeId);

        if(cachedEmployee != null) {
            return new ResponseEntity<Employee>(cachedEmployee, HttpStatus.OK);
        }

        Employee savedEmployee = employeeService.getEmployeeById(employeeId);

        employeeCache.add(employeeId, savedEmployee);

        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);

    }

    @GetMapping(value = "/products/{productId}")
    public ResponseEntity<Product> searchProductById(@PathVariable(value = "productId") int productId) {

        Product cachedProduct = productCache.get(productId);

        if(cachedProduct != null) {
            return new ResponseEntity<Product>(cachedProduct, HttpStatus.OK);
        }

        Product savedProduct = productService.getProductById(productId);

        productCache.add(productId, savedProduct);

        return new ResponseEntity<Product>(savedProduct, HttpStatus.OK);
    }

}
