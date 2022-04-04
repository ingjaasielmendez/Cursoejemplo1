package com.example.EjemploEmployee.Servs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EjemploEmployee.Clases.Book;
import com.example.EjemploEmployee.Repos.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookrepository;
	
	
	public Iterable<Book> findAll() {
		
		
		return bookrepository.findAll();
	}

	public Book save(Book book) {
	
	return bookrepository.save(book);
	
	
}

	public String findAndDeleteByTitle(String title ) {
	 
	 String response = "";
	 Optional<Book> bookFound = bookrepository.findByTitle(title);
	
	 if (bookFound.isPresent()) {

		bookrepository.delete(bookFound.get());
		response += "book deleted";
	}
	 
	 else {

		response += "book not found";
	}

	return response;
  }
	

	public Optional<Book> findByTitle(String title) {
		
		Optional<Book> response;
		 Optional<Book> bookFound = bookrepository.findByTitle(title);
		
		 if (bookFound.isPresent()) {

			
			response = bookFound;
		}
		 
		 else {

			response = null;
		}

		return response;
		
		
	  }
	
	public Book findBookByTitle(String title) {
	
		 Book response;
		 Optional<Book> bookFound = bookrepository.findByTitle(title);
		
		 if (bookFound.isPresent()) {

			
			response = bookFound.get();
		}
		 
		 else {

			response = null;
		}

		return response;
		
		
	  }
	
	
	
	 public Book findByTitle2(String title) {
		 
		 Book response2;
		 Optional<Book> bookFound2 = bookrepository.findByTitle(title);
		
		 if (bookFound2.isPresent()) {

			
			response2 = bookFound2.get();
		}
		 
		 else {

			response2 = null;
		}

		return response2;
		
		
	  }
	 
	
	
	
}
