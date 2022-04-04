package com.example.EjemploEmployee.Repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.EjemploEmployee.Clases.Author;

public interface AuthorRepository extends CrudRepository <Author, Integer>{
	
	Optional<Author> findByName(String name);

}
