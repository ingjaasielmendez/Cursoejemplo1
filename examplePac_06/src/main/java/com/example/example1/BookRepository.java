package com.example.example1;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Integer>{

	Optional<Book> findById(String id);

	Optional<Book> findByTitle(String title);
	
	void deleteById(String id);

	boolean existsById(String id);

	long countByAuthor(String author);

	void deleteByAuthor(String author);



	
	
	
	
	
	

}
