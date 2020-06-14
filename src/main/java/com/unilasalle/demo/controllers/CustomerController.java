package com.unilasalle.demo.controllers;

import com.unilasalle.demo.services.CustomerService;
import com.unilasalle.demo.entities.Customer;
import com.unilasalle.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @PostMapping("/api/customer")
    public ResponseEntity<?> insertCustomer(@RequestBody Customer customer) {
        if (customerService.validateCustomer(customer)) {
            customerRepository.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/customer/{id}")
    public ResponseEntity getCustomerById(@PathVariable long id) {
        Optional<Customer> user = customerRepository.findById(id);
        if (user == null)
            return new ResponseEntity("user not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
