package com.example.Restaurante.Repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.Restaurante.Clases.Customer;

public interface CustomerRepository extends CrudRepository <Customer, String> {
	Optional<Customer> findByUsername(String username);
	
}