package com.example.Restaurante.Serv;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Restaurante.Clases.Customer;
import com.example.Restaurante.Repos.CustomerRepository;


@Service
public class CustomerService {
	

	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	CustomerRepository customerrepository;
	
public Customer save(Customer customer) {
		
		return customerrepository.save(customer);
		
	}

public Customer check(Customer customer) {

	Optional<Customer> existing = customerrepository.findByUsername(customer.getUsername());
    existing.ifPresent(it-> {throw new IllegalArgumentException("customer already exists: " + it.getUsername());});

    String hash = encoder.encode(customer.getPassword());
    customer.setPassword(hash);

    return customer = customerrepository.save(customer);

 
  }


}
