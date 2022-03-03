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

		
	 //  LocalDate localDate = LocalDate.now(); book.setCreatedat(localDate);
		 
		
		//System.out.println("This is the object that gets from client/postman in java class book: " +  book);
		
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
	  
	  if ( indexBook.get() != null ) { //bookservice.deleteBookFromArray(title);
			
	  bookservice.findAndDeleteByTitle(indexBook.get().getTitle());
	  //System.out.println("Book found in " + indexBook + " and deleted");
	  responsedelete = responsedelete + "book: " + title + " - deleted #succes"; }
	  else { System.out.println("Book not found, not deleted"); responsedelete =
	  responsedelete + "book: " + title + " - not deleted book not found #fail"; }
	  
	  var headers = new HttpHeaders(); headers.add("ResponseDeleted",
	  "deleteBook executed"); headers.add("version", "1.0 Api Rest Book Object");
	  headers.add("Executed Output", responsedelete);
	  
	  return ResponseEntity.accepted().headers(headers).body(booktodelete); }
	 
	
	
	
	
	/*
	 * @PostMapping("/replaceBook/{title}") public String updateBook (@PathVariable
	 * String title, @RequestBody Book bookFromRest ) {
	 * 
	 * String responseUpdate = "";
	 * 
	 * int indexBook = bookservice.findBookByTilte (title); if ( indexBook == -1 ) {
	 * responseUpdate = responseUpdate + "book not found"; } else {
	 * 
	 * Book bookToUpdate = bookservice.getBookByIndex(indexBook);
	 * 
	 * //we are going to compare both books: //bookFromRest vs bookToUpdate //we
	 * need to compare each field of our object responseUpdate += "book found";
	 * 
	 * if (bookFromRest.getAuthor() != null) { responseUpdate +=
	 * " - author name value updated: " + bookFromRest.getAuthor() + "( old value: "
	 * + bookToUpdate.getAuthor() + ")" ; bookToUpdate.setAuthor(
	 * bookFromRest.getAuthor() ); } if (bookFromRest.getISBN() != null)
	 * bookToUpdate.setISBN( bookFromRest.getISBN() ); if (bookFromRest.getPages()
	 * != 0) bookToUpdate.setPages( bookFromRest.getPages());
	 * 
	 * 
	 * 
	 * 
	 * bookservice.replaceBook (indexBook, bookToUpdate);
	 * 
	 * }
	 * 
	 * 
	 * return responseUpdate;
	 * 
	 * 
	 * 
	 * }
	 */
	/*
	 * @PostMapping("/replaceBook/{title}") public ResponseEntity<Book> updateBook
	 * (@PathVariable String title, @RequestBody Book bookFromRest ) {
	 * 
	 * String responseUpdate = ""; Book bookToUpdate = null;
	 * 
	 * Optional<Book> indexBook = bookrepository.findByTitle(title); if ( indexBook
	 * == -1 ) { responseUpdate = responseUpdate + "book not found"; } else {
	 * 
	 * bookToUpdate = bookservice.getBookByIndex(indexBook);
	 * 
	 * //we are going to compare both books: //bookFromRest vs bookToUpdate //we
	 * need to compare each field of our object responseUpdate += "book found";
	 * boolean updated = false;
	 * 
	 * if (bookFromRest.getAuthor() != null) { responseUpdate +=
	 * " - author name value updated: " + bookFromRest.getAuthor() + "( old value: "
	 * + bookToUpdate.getAuthor() + ")" ;
	 * bookToUpdate.setAuthor(bookFromRest.getAuthor()); updated = true; } if
	 * (bookFromRest.getISBN() != null) { responseUpdate +=
	 * " - ISBN value updated: " + bookFromRest.getISBN() + "( old value: " +
	 * bookToUpdate.getISBN() + ")" ; bookToUpdate.setISBN(bookFromRest.getISBN());
	 * updated = true; } if (bookFromRest.getPages() != 0) { responseUpdate +=
	 * " - pages int value updated: " + bookFromRest.getPages() + "( old value: " +
	 * bookToUpdate.getPages() + ")" ;
	 * bookToUpdate.setPages(bookFromRest.getPages()); updated = true; } if
	 * (bookFromRest.getYear() != 0) { responseUpdate +=
	 * " - year int value updated: " + bookFromRest.getYear() + "( old value: " +
	 * bookToUpdate.getYear() + ")" ; bookToUpdate.setYear(bookFromRest.getYear());
	 * updated = true; }
	 * 
	 * if (!updated) responseUpdate +=
	 * " - try to update but any field updated - something wrong happened"; else
	 * bookservice.replaceBook (indexBook, bookToUpdate); }
	 * 
	 * var headers = new HttpHeaders(); headers.add("ResponseUpdate",
	 * "updateBook executed"); headers.add("version", "1.0 Api Rest Book Object");
	 * headers.add("Executed Output", responseUpdate);
	 * 
	 * return ResponseEntity.accepted().headers(headers).body(bookToUpdate);
	 * 
	 * 
	 * }
	 */
	
	
	
	@GetMapping("newspapers")
	public Iterable<Newspaper> getAllNewsPaper (){
		return null;
		
		
	} 
	
	@GetMapping("fakenews")
	public String getAllFakenew (){
		return "elreydimite";
		
		
		
		
	}
	
	
	
	@GetMapping("Author")
	public Iterable<Author> getAllAuthor (){
		return authorservice.queryAuthor();
		
		
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
	  
	  return ResponseEntity.accepted().headers(headers).body(authortodelete); }
	 
	/*
	 * @DeleteMapping ("/deleteAuthor/{name}") public String deleteAuthor
	 * (@PathVariable String name ) {
	 * 
	 * 
	 * 
	 * String responsedelete = ""; int indexAuthor = authorservice.findAuthorByName
	 * (name);
	 * 
	 * if ( indexAuthor != -1 ) { //Authorservice.deleteAuthorFromArray(name);
	 * authorservice.deleteAuthorFromArray(indexAuthor);
	 * System.out.println("Author found in " + indexAuthor + " and deleted");
	 * responsedelete = responsedelete + "author: " + name + " - deleted #succes"; }
	 * else { System.out.println("Author not found, not deleted"); responsedelete =
	 * responsedelete + "author: " + name + " - not deleted Author not found #fail";
	 * } return responsedelete; }
	 * 
	 * 
	 * @PostMapping("/replaceAuthor/{name}") public String updateAuthor
	 * (@PathVariable String name, @RequestBody Author authorFromRest ) {
	 * 
	 * String responseUpdate = "";
	 * 
	 * int indexAuthor = authorservice.findAuthorByName (name); if ( indexAuthor ==
	 * -1 ) { responseUpdate = responseUpdate + "Author not found"; } else {
	 * 
	 * Author authorToUpdate = authorservice.getAuthorByIndex(indexAuthor);
	 * 
	 * //we are going to compare both authors: //authorFromRest vs authorToUpdate
	 * //we need to compare each field of our object responseUpdate +=
	 * "Author found";
	 * 
	 * if (authorFromRest.getId() != 0) { responseUpdate += " - id value updated: "
	 * + authorFromRest.getId() + "( old value: " + authorToUpdate.getId() + ")" ;
	 * authorToUpdate.setId( authorFromRest.getId() ); }
	 * 
	 * if (authorFromRest.getName() != null) authorToUpdate.setName(
	 * authorFromRest.getName() ); if (authorFromRest.getCountry() != null)
	 * authorToUpdate.setCountry( authorFromRest.getCountry() ); if
	 * (authorFromRest.getDob() != 0) authorToUpdate.setDob(
	 * authorFromRest.getDob()); if (authorFromRest.getQtyBooks() != 0)
	 * authorToUpdate.setQtyBooks( authorFromRest.getQtyBooks() ); if
	 * (authorFromRest.getAlive() != null) authorToUpdate.setAlive(
	 * authorFromRest.getAlive() );
	 * 
	 * 
	 * authorservice.replaceAuthor(indexAuthor, authorToUpdate);
	 * 
	 * }
	 * 
	 * 
	 * return responseUpdate;
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
		
	
	
}
