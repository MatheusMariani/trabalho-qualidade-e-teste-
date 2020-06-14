package com.unilasalle.demo.controllers;


import com.unilasalle.demo.entities.Product;
import com.unilasalle.demo.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class SaleController {

    @Autowired
    SaleRepository saleRepository;
}
