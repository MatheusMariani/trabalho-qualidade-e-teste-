package com.unilasalle.demo.Service;

import com.unilasalle.demo.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public boolean validateCustomer(Customer customer) {
        customer.setCpf(customer.getCpf().replace(".", "")
                .replace("-", ""));

        if (customer.getEmail().contains("@") &&
                !customer.getName().isEmpty() &&
                customer.getCpf().length() == 11) {
            return true;
        }
        return false;
    }
}
