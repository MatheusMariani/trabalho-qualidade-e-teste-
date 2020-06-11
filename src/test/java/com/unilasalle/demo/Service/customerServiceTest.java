package com.unilasalle.demo.Service;


import com.unilasalle.demo.entities.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class customerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void shouldReturnTrueWhenValidCustomer(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Matheus");
        customer.setEmail("matheusjava@java.com");
        customer.setPhone("test");
        customer.setCpf("235.502.205-15");

        Assert.assertTrue(customerService.validateCustomer(customer));
    }

    @Test
    public void shouldReturnFalseWhenInvalidCpf(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Matheus");
        customer.setEmail("matheusjava@java.com");
        customer.setPhone("test");
        customer.setCpf("235.150.2205-15");

        Assert.assertFalse(customerService.validateCustomer(customer));
    }

    @Test
    public void shouldReturnFalseWhenNameIsBlank(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("");
        customer.setEmail("matheusjava@java.com");
        customer.setPhone("test");
        customer.setCpf("235.502.205-15");

        Assert.assertFalse(customerService.validateCustomer(customer));
    }

    @Test
    public void shouldReturnFalseWhenInvalidEmail(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Matheus");
        customer.setEmail("INVALID EMAIL");
        customer.setPhone("test");
        customer.setCpf("235.502.205-15");

        Assert.assertFalse(customerService.validateCustomer(customer));
    }
}
