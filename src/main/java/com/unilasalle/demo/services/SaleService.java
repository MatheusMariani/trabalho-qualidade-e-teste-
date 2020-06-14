package com.unilasalle.demo.services;

import com.unilasalle.demo.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;


}
