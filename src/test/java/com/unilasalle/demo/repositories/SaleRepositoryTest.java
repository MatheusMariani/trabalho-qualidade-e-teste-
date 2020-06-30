package com.unilasalle.demo.repositories;

import com.unilasalle.demo.controllers.SaleController;
import com.unilasalle.demo.entities.Customer;
import com.unilasalle.demo.entities.Product;
import com.unilasalle.demo.entities.Sale;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SaleRepositoryTest {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleController saleController;


    @Test
    public void shouldGetSaleCustomerData(){
        Customer customer = new Customer();
        customer.setId((long) 1);
        customer.setName("Matheus");
        customer.setEmail("matheusjava@java.com");
        customer.setPhone("12345678");
        customer.setCpf("235.502.205-15");

        customerRepository.save(customer); //adicionando dados no banco

        Product product = new Product();
        product.setId((long) 1);
        product.setName("Headset Gamer");
        product.setPrice(80.50);
        List<Product> products = new ArrayList<>();
        products.add(product);

        productRepository.save(product); //adicionando dados no banco

        Sale sale = new Sale();
        sale.setId((long) 1);
        sale.setCustomer(customer);
        sale.setProducts(products);

        saleRepository.save(sale);

        Sale saleAfterInsert = saleController.getSaleInfo(1); //Armazenando os dados recebidos após o mapeamento do banco

        Assert.assertEquals("Matheus",saleAfterInsert.getCustomer().getName());
        Assert.assertEquals("Headset Gamer",saleAfterInsert.getProducts().get(0).getName());
    }
}
