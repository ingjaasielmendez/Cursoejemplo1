package com.example.Restaurante.Repos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Restaurante.Clases.CustomerImgQR;

public interface CustomerImagesRepository extends MongoRepository<CustomerImgQR, String> {
	Optional<CustomerImgQR> findByUsername(String username);
}
