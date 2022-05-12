package com.example.Restaurante.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Restaurante.Clases.CustomerImgQR;

public interface CustomerImagesRepository extends MongoRepository<CustomerImgQR, String> {

}
