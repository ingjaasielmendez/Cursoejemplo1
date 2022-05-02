package com.example.Restaurante.Serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Restaurante.Clases.Customer;
import com.example.Restaurante.Repos.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerrepository;
	
public Customer save(Customer customer) {
		
		return customerrepository.save(customer);
		
	}

}
