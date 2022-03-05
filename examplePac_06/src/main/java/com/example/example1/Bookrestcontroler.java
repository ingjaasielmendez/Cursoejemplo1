package com.example.example1;

import java.util.Optional;



/*import java.time.LocalDate;*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//this annotation is for tell this class that it is a REST CONTROLLER CLASS
@RestController
@RequestMapping("apilibrary")
public class Bookrestcontroler {

	@Autowired
	Bookservice bookservice;
	
	@Autowired
	Authorservice authorservice;
	@Autowired
	BookRepository bookrepository;
	@Autowired
	AuthorRepository authorrepository;

	
	

	
	@GetMapping("books")
	public ResponseEntity<Iterable<Book>> findAll() {
		
		var headers = new HttpHeaders();
		headers.add("ResponseGet", "findAll() executed");
		headers.add("version", "1.0 Api Rest Book Object");
		
		return ResponseEntity.accepted().headers(headers).body(bookrepository.findAll());
	}
	
	
	
	
	@PostMapping(path = "/addBook", consumes = "application/json" )
	public ResponseEntity<Book> createBook(@RequestBody Book book) {

		
	 
		
		Book bookSaved = bookrepository.save(book);
		
		var headers = new HttpHeaders();
		headers.add("ResponseCreate", "createBook executed");
		headers.add("version", "1.0 Api Rest Book Object");
		headers.add("Executed Output", "book created");
		
		return ResponseEntity.accepted().headers(headers).body(bookSaved);
		
	}
	
	
	 
	 
	
	
	  @DeleteMapping ("/deleteBook/{title}") 
	  public ResponseEntity<Book> deleteBook
	  (@PathVariable String title ) {
	  
	  String responsedelete = ""; 
	  Optional<Book> indexBook = bookrepository.findByTitle(title); 
	  Book booktodelete = null;
	  
	  if ( indexBook.get() != null ) { 
			
	  bookservice.findAndDeleteByTitle(indexBook.get().getTitle());
	 
	  responsedelete = responsedelete + "book: " + title + " - deleted #succes"; }
	  else { System.out.println("Book not found, not deleted"); responsedelete =
	  responsedelete + "book: " + title + " - not deleted book not found #fail"; }
	  
	  var headers = new HttpHeaders(); headers.add("ResponseDeleted",
	  "deleteBook executed"); headers.add("version", "1.0 Api Rest Book Object");
	  headers.add("Executed Output", responsedelete);
	  
	  return ResponseEntity.accepted().headers(headers).body(booktodelete); }
	 
	
	
	
	
	  @PostMapping("/replaceBook/{title}") 
	  public ResponseEntity<Book> updateBook
	  (@PathVariable String title, @RequestBody Book bookFromRest ) {
	  
	  String responseUpdate = ""; 
	  
	  
	  Book bookToUpdate = null;
	  Optional <Book> indexBook = bookrepository.findByTitle(title); 
	  Book indexbook2 = bookservice.findByTitle2(title);
	  if ( indexBook.get() == null ) { responseUpdate = responseUpdate + "book not found"; } 
	  
	  else {
	  
	  bookToUpdate = bookservice.findBookByTitle(title);
	  
	  responseUpdate += "book found";
	  boolean updated = false;
	  
	  if (bookFromRest.getId() != null) { responseUpdate +=
			  " - author id value updated: " + bookFromRest.getId() + "( old value: "
			  + bookToUpdate.getId() + ")" ;
			  bookToUpdate.setId(bookFromRest.getId()); updated = true; } 
	  
	  if (bookFromRest.getAuthor() != null) { responseUpdate +=
	  " - author name value updated: " + bookFromRest.getAuthor() + "( old value: "
	  + bookToUpdate.getAuthor() + ")" ;
	  bookToUpdate.setAuthor(bookFromRest.getAuthor()); updated = true; } 
	  if
	  (bookFromRest.getISBN() != null) { responseUpdate +=
	  " - ISBN value updated: " + bookFromRest.getISBN() + "( old value: " +
	  bookToUpdate.getISBN() + ")" ; bookToUpdate.setISBN(bookFromRest.getISBN());
	  updated = true; } 
	  if (bookFromRest.getPages() != 0) { responseUpdate +=
	  " - pages int value updated: " + bookFromRest.getPages() + "( old value: " +
	  bookToUpdate.getPages() + ")" ;
	  bookToUpdate.setPages(bookFromRest.getPages()); updated = true; } 
	  if
	  (bookFromRest.getYear() != 0) { responseUpdate +=
	  " - year int value updated: " + bookFromRest.getYear() + "( old value: " +
	  bookToUpdate.getYear() + ")" ; bookToUpdate.setYear(bookFromRest.getYear());
	  updated = true; }
	  
	  if (!updated) responseUpdate +=
	  " - try to update but any field updated - something wrong happened"; 
	  else
		  bookToUpdate = indexbook2;
		  bookrepository.save (bookToUpdate); }
	  
	  var headers = new HttpHeaders(); headers.add("ResponseUpdate",
	  "updateBook executed"); headers.add("version", "1.0 Api Rest Book Object");
	  headers.add("Executed Output", responseUpdate);
	  
	  return ResponseEntity.accepted().headers(headers).body(bookToUpdate);
	  
	  
	  }
	 
	
	
	
	@GetMapping("newspapers")
	public Iterable<Newspaper> getAllNewsPaper (){
		return null;
		
		
	} 
	
	@GetMapping("fakenews")
	public String getAllFakenew (){
		return "elreydimite";
		
		
		
		
	}
	
	
	
	
	
	@GetMapping("Author")
	public ResponseEntity<Iterable<Author>> findAll1() {
		
		var headers = new HttpHeaders();
		headers.add("ResponseGet", "findAll() executed");
		headers.add("version", "1.0 Api Rest Author Object");
		
		return ResponseEntity.accepted().headers(headers).body(authorrepository.findAll());
	}
	
	
	@PostMapping(path = "/addAuthor", consumes = "application/json" )
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {

		
	 
		Author authorSaved = authorrepository.save(author);
		
		var headers = new HttpHeaders();
		headers.add("ResponseCreate", "createAuthor executed");
		headers.add("version", "1.0 Api Rest Author Object");
		headers.add("Executed Output", "author created");
		
		return ResponseEntity.accepted().headers(headers).body(authorSaved);
		
	}
	@DeleteMapping ("/deleteAuthor/{name}") 
	  public ResponseEntity<Author> deleteAuthor
	  (@PathVariable String name ) {
	  
	  String responsedelete = ""; 
	  Optional<Author> indexAuthor = authorrepository.findByName(name); 
	  Author authortodelete = null;
	  
	  if ( indexAuthor.get() != null ) { 
		  
		 
			
	  authorservice.findAndDeleteByName(indexAuthor.get().getName());
	  
	  responsedelete = responsedelete + "author: " + name + " - deleted #succes"; }
	  else { System.out.println("Author not found, not deleted"); responsedelete =
	  responsedelete + "author: " + name + " - not deleted author not found #fail"; }
	  
	  var headers = new HttpHeaders(); headers.add("ResponseDeleted",
	  "deleteAuthor executed"); headers.add("version", "1.0 Api Rest Author Object");
	  headers.add("Executed Output", responsedelete);
	  
	  return ResponseEntity.accepted().headers(headers).body(authortodelete); 
	  
	}
	 
	
	 
		
	@PostMapping("/replaceAuthor/{name}") 
	  public ResponseEntity<Author> updateAuthor
	  (@PathVariable String name, @RequestBody Author authorFromRest ) {
	  
	  String responseUpdate = ""; 
	  
	  
	  Author authorToUpdate = null;
	  Optional <Author> indexAuthor = authorrepository.findByName(name); 
	  Author indexauthor2 = authorservice.findByName2(name);
	  if ( indexAuthor.get() == null ) { responseUpdate = responseUpdate + "author not found"; } 
	  
	  else {
	  
	  authorToUpdate = authorservice.findAuthorByName(name);
	  
	  responseUpdate += "author found";
	  boolean updated = false;
	  
	  if (authorFromRest.getId() != null) { responseUpdate +=
	  " - author id value updated: " + authorFromRest.getId() + "( old value: "		
	  + authorToUpdate.getId() + ")" ;
	  authorToUpdate.setId(authorFromRest.getId()); updated = true; } 
	  
	  if (authorFromRest.getCountry() != null) { responseUpdate +=
	  " - Country value updated: " + authorFromRest.getCountry() + "( old value: "
	  + authorToUpdate.getCountry() + ")" ;
	  authorToUpdate.setCountry(authorFromRest.getCountry()); updated = true; } 
	 
	  if
	  (authorFromRest.getDob() != 0) { responseUpdate +=
	  " - Dob value updated: " + authorFromRest.getDob() + "( old value: " +
			  authorToUpdate.getDob() + ")" ; authorToUpdate.setDob(authorFromRest.getDob());
	  updated = true; } 
	  
	  if (authorFromRest.getQtyBooks() != 0) { responseUpdate +=
	  " - QtyBooks int value updated: " + authorFromRest.getQtyBooks() + "( old value: " +
			  authorToUpdate.getQtyBooks() + ")" ;
	  authorToUpdate.setQtyBooks(authorFromRest.getQtyBooks()); updated = true; } 
	  
	  if
	  (authorFromRest.getAlive() != null) { responseUpdate +=
	  " - Alive int value updated: " + authorFromRest.getAlive() + "( old value: " +
			  authorToUpdate.getAlive() + ")" ; authorToUpdate.setAlive(authorFromRest.getAlive());
	  updated = true; }
	  
	  if (!updated) responseUpdate +=
	  " - try to update but any field updated - something wrong happened"; 
	  else
		  authorToUpdate = indexauthor2;
		  authorrepository.save (authorToUpdate); }
	  
	  var headers = new HttpHeaders(); headers.add("ResponseUpdate",
	  "updateAuthor executed"); headers.add("version", "1.0 Api Rest Author Object");
	  headers.add("Executed Output", responseUpdate);
	  
	  return ResponseEntity.accepted().headers(headers).body(authorToUpdate);
	  
	  }
	
}
