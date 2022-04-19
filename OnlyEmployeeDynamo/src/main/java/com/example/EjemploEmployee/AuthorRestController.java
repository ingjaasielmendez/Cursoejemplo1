package com.example.EjemploEmployee;

import java.util.Optional;

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

import com.example.EjemploEmployee.Clases.Author;
import com.example.EjemploEmployee.Servs.AuthorService;

@RestController
@RequestMapping("apilibrary")
public class AuthorRestController {

	
	
	@Autowired
	AuthorService authorservice;
	
	
	
	
	
	
	@GetMapping("Author")
	public ResponseEntity<Iterable<Author>> findAll1() {
		
		var headers = new HttpHeaders();
		headers.add("ResponseGet", "findAll() executed");
		headers.add("version", "1.0 Api Rest Author Object");
		
		return ResponseEntity.accepted().headers(headers).body(authorservice.findAll());
	}
	
	
	
	  @PostMapping(path = "/addAuthor", consumes = "application/json" )
	  public ResponseEntity<Author> createAuthor(@RequestBody Author author) {

		
	 
		Author authorSaved = authorservice.save(author);
		
		var headers = new HttpHeaders();
		headers.add("ResponseCreate", "createAuthor executed");
		headers.add("version", "1.0 Api Rest Author Object");
		headers.add("Executed Output", "author created");
		
		return ResponseEntity.accepted().headers(headers).body(authorSaved);
		
	}
	
	
	  @DeleteMapping ("/deleteAuthor/{name}") 
	  public ResponseEntity<Author> deleteAuthor(@PathVariable String name ) {
	  
	  String responsedelete = ""; 
	  Optional<Author> indexAuthor = authorservice.findByName(name); 
	  Author authortodelete = null;
	  
	  if ( indexAuthor.get() != null ) { 
		  
		 
			
	  authorservice.findAndDeleteByName(indexAuthor.get().getName());
	  
	  responsedelete = responsedelete + "author: " + name + " - deleted #succes"; }
	  
	  else 
	  
	  { System.out.println("Author not found, not deleted"); responsedelete =
	  responsedelete + "author: " + name + " - not deleted author not found #fail"; }
	  
	  var headers = new HttpHeaders(); headers.add("ResponseDeleted",
	  "deleteAuthor executed"); headers.add("version", "1.0 Api Rest Author Object");
	  headers.add("Executed Output", responsedelete);
	  
	  return ResponseEntity.accepted().headers(headers).body(authortodelete); 
	  
	}
	 
	
	 
		
	  @PostMapping(path = "/replaceAuthor/{name}", consumes = "application/json" )  
	  public ResponseEntity<Author> updateAuthor( @PathVariable String name, @RequestBody Author author ){
      
		  
	  String responseUpdate = ""; 
	  Optional <Author> indexAuthor = authorservice.findByName(name); 
	  var headers = new HttpHeaders();
	  Author authorSaved = null;
	  
	  if ( indexAuthor.get() == null ) { responseUpdate = responseUpdate + "author not found"; } 
	  
	  else {
	  
		 authorSaved = authorservice.save(author);
	  
	  responseUpdate += "author found";
	 
	  
	   
		
	   
	  headers.add("ResponseUpdate","updateAuthor executed"); 
	  headers.add("version", "1.0 Api Rest Author Object");
	  headers.add("Executed Output", responseUpdate);
	  }
	  return ResponseEntity.accepted().headers(headers).body(authorSaved);
		
	  
	  
	  }
}
