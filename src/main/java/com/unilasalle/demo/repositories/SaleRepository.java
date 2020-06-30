package com.unilasalle.demo.repositories;

import com.unilasalle.demo.entities.Customer;
import com.unilasalle.demo.entities.Product;
import com.unilasalle.demo.entities.Sale;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;


public interface SaleRepository extends CrudRepository<Sale, Long> {
    Sale getById(long id );
}
