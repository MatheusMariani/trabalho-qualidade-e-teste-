package com.unilasalle.demo.repositories;

import com.unilasalle.demo.entities.Sale;

import org.springframework.data.repository.CrudRepository;



public interface SaleRepository extends CrudRepository<Sale, Long> {

}
