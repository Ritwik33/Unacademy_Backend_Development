package com.unacademy.cartService.controllers;

import com.unacademy.cartService.dtos.CustomerDTO;
import com.unacademy.cartService.entities.Customer;
import com.unacademy.cartService.exceptions.CustomerWithThisIdNotFoundException;
import com.unacademy.cartService.exceptions.NoCustomerExistsException;
import com.unacademy.cartService.exceptions.NoCustomerFoundWithThisNameException;
import com.unacademy.cartService.services.Impl.CustomerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = convertCustomerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerService.createCustomer(customer);
        CustomerDTO responseBody = convertCustomerToCustomerDTO(savedCustomer);
        return new ResponseEntity<CustomerDTO>(responseBody, HttpStatus.CREATED);
    }

    @PostMapping(value = "/customerList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDTO>> createMultipleCustomers(@RequestBody List<CustomerDTO> customerDTOS) {

        List<Customer> customers = new ArrayList<>();
        customerDTOS.forEach(customerDTO -> customers.add(convertCustomerDTOToCustomer(customerDTO)));
        List<Customer> savedCustomers = customerService.createMultipleCustomers(customers);
        List<CustomerDTO> responseBody = new ArrayList<>();
        savedCustomers.forEach(customer -> responseBody.add(convertCustomerToCustomerDTO(customer)));
        return new ResponseEntity<List<CustomerDTO>>(responseBody, HttpStatus.CREATED);

    }

    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> getCustomerDetailsByCustomerId(@PathVariable(value = "customerId") int customerId)
            throws CustomerWithThisIdNotFoundException {

        Customer foundCustomer = customerService.getCustomerDetailsByCustomerId(customerId);
        CustomerDTO responseBody = convertCustomerToCustomerDTO(foundCustomer);
        return new ResponseEntity<CustomerDTO>(responseBody, HttpStatus.OK);

    }

    @GetMapping(value = "/customerName/{customerName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDTO>> getCustomerDetailsByCustomerName(@PathVariable(value = "customerName") String customerName)
            throws NoCustomerFoundWithThisNameException {

        List<Customer> foundCustomers = customerService.getCustomersDetailsByCustomerName(customerName);
        List<CustomerDTO> responseBody = new ArrayList<>();
        foundCustomers.forEach(customer -> responseBody.add(convertCustomerToCustomerDTO(customer)));
        return new ResponseEntity<List<CustomerDTO>>(responseBody, HttpStatus.OK);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDTO>> getListOfAllCustomers() throws NoCustomerExistsException {
        List<Customer> foundCustomers = customerService.getAllCustomers();
        List<CustomerDTO> responseBody = new ArrayList<CustomerDTO>();
        foundCustomers.forEach(customer -> responseBody.add(convertCustomerToCustomerDTO(customer)));
        return new ResponseEntity<List<CustomerDTO>>(responseBody, HttpStatus.OK);
    }

    @PutMapping(value = "/{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> updateCustomerDetails(@PathVariable(value = "customerId") int customerId, @RequestBody CustomerDTO customerDTO)
            throws CustomerWithThisIdNotFoundException {

        Customer customerUpdater = convertCustomerDTOToCustomer(customerDTO);
        Customer updatedCustomer = customerService.updateCustomerDetails(customerId, customerUpdater);
        CustomerDTO responseBody = convertCustomerToCustomerDTO(updatedCustomer);
        return new ResponseEntity<CustomerDTO>(responseBody, HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "customerId") int customerId)
            throws CustomerWithThisIdNotFoundException {

        customerService.deleteCustomer(customerId);
        return new ResponseEntity<String>("customer with id : [" + customerId + "] successfully deleted", HttpStatus.OK);

    }

    private CustomerDTO convertCustomerToCustomerDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    private Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }

}
