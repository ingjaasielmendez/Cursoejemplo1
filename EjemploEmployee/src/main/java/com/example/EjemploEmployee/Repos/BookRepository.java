package com.example.EjemploEmployee.Repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.EjemploEmployee.Clases.Book;

public interface BookRepository extends CrudRepository <Book, Integer>{

	Optional<Book> findById(String id);

	Optional<Book> findByTitle(String title);

}
