package com.example.Restaurante.Serv;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Restaurante.Clases.CustomerImgQR;
import com.example.Restaurante.Repos.CustomerImagesRepository;

public class CustomerServiceImg {

	@Autowired
	CustomerImagesRepository customerimagesrepository;

public CustomerImgQR save(CustomerImgQR customerimages) {
	
	return customerimagesrepository.save(customerimages);
	
}

public CustomerImgQR findByUsername(String username) {
	
	return customerimagesrepository.findByUsername(username).get();
	
}
	
}
