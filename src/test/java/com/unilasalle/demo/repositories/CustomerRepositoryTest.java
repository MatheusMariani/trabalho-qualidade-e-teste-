package com.unilasalle.demo.repositories;



import com.unilasalle.demo.entities.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void shouldInsertCustomerIntoDatabase(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Matheus");
        customer.setEmail("matheusjava@java.com");
        customer.setPhone("test");
        customer.setCpf("235.502.205-15");

        customerRepository.save(customer);

        Assert.assertNotNull(customerRepository.findByName("Matheus"));
    }

    @Test
    public void shouldFindByEmail(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Customer Test");
        customer.setEmail("customertest@java.com");
        customer.setPhone("test");
        customer.setCpf("235.502.205-15");

        customerRepository.save(customer);

        Assert.assertNotNull(customerRepository.findUserByEmail("customertest@java.com"));
    }
}
