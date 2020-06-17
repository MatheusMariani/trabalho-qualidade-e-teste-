package com.unilasalle.demo.services;

import com.unilasalle.demo.entities.Customer;
import com.unilasalle.demo.exceptions.BusinessException;
import com.unilasalle.demo.models.CustomerModel;
import com.unilasalle.demo.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

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
    
    
    public CustomerModel getCustomerById(int customerId)  {
    	Customer customer = customerRepository.findCustomerById(customerId);
    	if(customer == null)
    		throw new BusinessException("Operação inválida");
    	return new CustomerModel(customer);
    }
    
    public CustomerModel registerCustomer(Customer customer) {
    	if(!existingCustomer(customer.getCpf()))
    		customerRepository.save(customer);
    	
    	return new CustomerModel(customer);
    }
    
    public boolean existingCustomer(String customerCPF) {
    	Customer existingCustomer = customerRepository.findByCPF(customerCPF);
    	
    	if(existingCustomer != null) 
    		throw new BusinessException("Já existe um cadastro vinculado ao CPF informado");
 
    	return false;
    }
}
