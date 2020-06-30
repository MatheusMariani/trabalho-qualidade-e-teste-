package com.unilasalle.demo.repositories;



import com.unilasalle.demo.entities.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void shouldInsertCustomerIntoDatabase(){
        Customer customer = new Customer();
        customer.setId((long) 1);
        customer.setName("Matheus");
        customer.setEmail("matheusjava@java.com");
        customer.setPhone("12345678");
        customer.setCpf("235.502.205-15");

        customerRepository.save(customer);
        List<Customer> customerFromDatabase = customerRepository.findByName("Matheus");

        Assert.assertNotNull(customerFromDatabase);
        Assert.assertEquals("Matheus",customerFromDatabase.get(0).getName());
        Assert.assertEquals("matheusjava@java.com",customerFromDatabase.get(0).getEmail());
        Assert.assertEquals("12345678",customerFromDatabase.get(0).getPhone());
        Assert.assertEquals("235.502.205-15",customerFromDatabase.get(0).getCpf());
    }

    @Test
    public void shouldFindByEmail(){
        Customer customer = new Customer();
        customer.setId((long) 1);
        customer.setName("Customer Test");
        customer.setEmail("customertest@java.com");
        customer.setPhone("test");
        customer.setCpf("235.502.205-15");

        customerRepository.save(customer);

        Assert.assertNotNull(customerRepository.findUserByEmail("customertest@java.com"));
    }
}
