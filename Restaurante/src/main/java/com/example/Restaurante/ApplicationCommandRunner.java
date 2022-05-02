package com.example.Restaurante;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Restaurante.Clases.Customer;
import com.example.Restaurante.Serv.CustomerService;





@Component
public class ApplicationCommandRunner implements CommandLineRunner {
    
	@Autowired
	CustomerService customerservice;
	
protected final Log logger = LogFactory.getLog(getClass());
	
	
	@Override
	public void run(String... args) throws Exception {
	
		logger.info("Welcome to the runner from commandLineRunner");
		// Long id, String firstName, String lastName, String username, String password
		Customer customer1 = new Customer((long) 1, "Toni", "Montana", "toni3", "$2a$12$p7soZI3kAFcxv7QFRFzNP.gjmhHrpDACSJpoTmJQnFFWD6u7IeXNe");
		
		customerservice.save(customer1);
	
  }
	
}
