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
	/*
	 * static List<Author> Authors = new ArrayList<Author>();
	 * 
	 * 
	 * static {
	 * 
	 * //int id, String name, String country, int dob, int qtyBooks, Boolean alive
	 * 
	 * }
	 */

public Iterable<Author> queryAuthor() {
	/* System.out.println ("Authors" + Authors); */
	return authorrepository.findAll();
	
	}
	
public Author addAuthorToH2(Author author) {
	authorrepository.save(author);
	return author;
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


/*
 * public String deleteAuthorFromArray(String name ) {
 * 
 * int index = findAuthorByName(name); Authors.remove(index);
 * 
 * return "Author deleted by name"; }
 * 
 * public String deleteAuthorFromArray(int index ) {
 * 
 * Authors.remove(index);
 * 
 * return "Author deleted by index"; }
 * 
 * public int findAuthorByName(String name) {
 * 
 * int index = -1; for ( Author authorTemporal : Authors) {
 * 
 * if ( authorTemporal.getName().equals(name) ) { index =
 * Authors.indexOf(authorTemporal); } } return index; }
 * 
 * public Author replaceAuthor(int indexAuthor, Author author) {
 * 
 * Authors.set(indexAuthor, author);
 * 
 * 
 * return author;
 * 
 * }
 * 
 * 
 * public Author getAuthorByIndex (int index) {
 * 
 * Author author = Authors.get(index);
 * 
 * return author; }
 */

}
