package com.example.EjemploEmployee;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, Integer>{
	
	Optional<Author> findByName(String name);

}
