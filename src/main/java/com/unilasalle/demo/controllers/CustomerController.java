package com.unilasalle.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.unilasalle.demo.entities.Customer;
import com.unilasalle.demo.models.CustomerModel;
import com.unilasalle.demo.repositories.CustomerRepository;
import com.unilasalle.demo.services.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @PostMapping("/api/customer")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        if (customerService.validateCustomer(customer)) {
            customerService.registerCustomer(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/customer/{customerId}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable int customerId) {
        CustomerModel foundCustomer = customerService.getCustomerById(customerId);
         return new ResponseEntity<CustomerModel>(foundCustomer, HttpStatus.OK);
    }
}
