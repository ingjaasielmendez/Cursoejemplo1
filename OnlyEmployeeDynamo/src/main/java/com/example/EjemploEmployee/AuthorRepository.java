package com.example.EjemploEmployee;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.example.EjemploEmployee.Clases.Author;

@EnableScan
public interface AuthorRepository extends CrudRepository<Author, Integer>{

	Optional<Author> findByName(String name);
	
}
