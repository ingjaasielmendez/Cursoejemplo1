package com.example.example1;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, String>{
	
	Optional<Author> findByName(String name);

	}





