package com.example.example1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

/*import java.util.ArrayList;
import java.util.List;*/

import org.springframework.stereotype.Service;

@Service
public class Authorservice {
   
	@Autowired
	AuthorRepository authorrepository;
	

public Iterable<Author> findAll() {
	/* System.out.println ("Authors" + Authors); */
	return authorrepository.findAll();
	
	}
	
public void save(Author author) {
	authorrepository.save(author);
	
}
	
public String findAndDeleteByName(String name ) {
	 String response = "";
	 Optional<Author> authorFound = authorrepository.findByName(name);
	if (authorFound.isPresent()) {

		authorrepository.delete(authorFound.get());
		response += "author deleted";
	} else {

		response += "author not found";
	}

	return response;
 }

public Author findAuthorByName(String name) {
	 Author response;
	 Optional<Author> authorFound = authorrepository.findByName(name);
	if (authorFound.isPresent()) {

		
		response = authorFound.get();
	} else {

		response = null;
	}

	return response;
	
	
 }

public Author findByName2(String name) {
	 Author response2;
	 Optional<Author> authorFound2 = authorrepository.findByName(name);
	if (authorFound2.isPresent()) {

		
		response2 = authorFound2.get();
	} else {

		response2 = null;
	}

	return response2;
	
	
 }
}
