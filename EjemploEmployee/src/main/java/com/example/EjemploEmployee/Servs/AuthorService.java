package com.example.EjemploEmployee.Servs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EjemploEmployee.Clases.Author;
import com.example.EjemploEmployee.Repos.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorrepository;

	public Iterable<Author> findAll() {
	
		return authorrepository.findAll();
		
	}
		
	
	public Author save(Author author) {
		
		return authorrepository.save(author);
		
	}
	
	
	public String findAndDeleteByName(String name ) {
		
		String response = "";
		Optional<Author> authorFound = authorrepository.findByName(name);
		
		if (authorFound.isPresent()) {

			authorrepository.delete(authorFound.get());
			response += "author deleted";
		}
		
		else {

			response += "author not found";
		}

		return response;
	 }

	
	public Optional<Author> findByName(String name) {
		
	     Optional<Author> response;
		 Optional<Author> authorFound = authorrepository.findByName(name);
		
		 if (authorFound.isPresent()) {

			
			response = authorFound;
		}
		 
		 else {

			response = null;
		}

		return response;
		
		
	  }
	
	
	
	
	public Author findAuthorByName(String name) {
		
		 Author response;
		 Optional<Author> authorFound = authorrepository.findByName(name);
		
		 if (authorFound.isPresent()) {

			
			response = authorFound.get();
		}
		 
		 else {

			response = null;
		}

		return response;
		
		
	 }
	
	
	
	public Author findByName2(String name) {
		
		 Author response2;
		 Optional<Author> authorFound2 = authorrepository.findByName(name);
		
		 if (authorFound2.isPresent()) {

			
			response2 = authorFound2.get();
		}
		 
		 else {

			response2 = null;
		}

		return response2;
		
		
	 }
	
	
}
