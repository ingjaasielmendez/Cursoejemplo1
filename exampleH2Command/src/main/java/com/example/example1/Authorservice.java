package com.example.example1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Authorservice {

	static List<Author>  Authors = new ArrayList<Author>();	
	

	static {
			
			//int id, String name, String country, int dob, int qtyBooks, Boolean alive
			Author author1 = new Author ( 1, "Tolstoi", "Rusia", 1896, 12, false);
			Author author2 = new Author ( 2, "V Wolf", "EEUU", 235, 16, true);
			Author author3 = new Author ( 3, "Anna", "España", 2, 20, true);
			//Author author4 = new Author ();
			//Author author5 = new Author ();
			//Author author6 = new Author ();
			Authors.add(author1);
			Authors.add(author2);
			Authors.add(author3);
	}

public List<Author> queryAuthor() {
	System.out.println ("Authors" + Authors);
	return Authors;
	
	}
	
public Author addAuthorToArray(Author author) {
	Authors.add(author);
	return author;
}
	
public String deleteAuthorFromArray(String name ) {
	
	int index = findAuthorByName(name);
	Authors.remove(index);
	
	return "Author deleted by name";
}

public String deleteAuthorFromArray(int index ) {
	
	Authors.remove(index);
	
	return "Author deleted by index";
}

public int findAuthorByName(String name) {
	
	int index = -1;
	for ( Author authorTemporal  : Authors) {
		
		if ( authorTemporal.getName().equals(name) ) {	
			index = Authors.indexOf(authorTemporal);
		}
	}
	return index;
}

public Author replaceAuthor(int indexAuthor, Author author) {
	
	Authors.set(indexAuthor, author);
	
	
	return author;
	
}


public Author getAuthorByIndex (int index) {
	
	Author author = Authors.get(index);
	
	return author;
}


}
