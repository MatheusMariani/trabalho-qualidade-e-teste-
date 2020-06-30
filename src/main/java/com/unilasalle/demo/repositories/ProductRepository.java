package com.unilasalle.demo.repositories;


import com.unilasalle.demo.entities.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {
}