package com.example.EjemploEmployee;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Integer>{

	Optional<Book> findById(String id);

	Optional<Book> findByTitle(String title);

}
