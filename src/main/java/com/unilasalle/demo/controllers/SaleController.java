package com.unilasalle.demo.controllers;


import com.unilasalle.demo.entities.Sale;
import com.unilasalle.demo.repositories.CustomerRepository;
import com.unilasalle.demo.repositories.ProductRepository;
import com.unilasalle.demo.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Optional;

@Controller
public class SaleController {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public Sale getSaleInfo(long id){
       return saleRepository.getById(id);
    }

}
