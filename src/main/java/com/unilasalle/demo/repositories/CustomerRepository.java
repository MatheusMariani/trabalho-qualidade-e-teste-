package com.unilasalle.demo.repositories;

import com.unilasalle.demo.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByName(String name);

    @Query(value = "select * from customer where email = :email", nativeQuery = true)
    Customer findUserByEmail(@Param("email") String email);
}