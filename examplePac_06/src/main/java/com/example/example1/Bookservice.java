package com.example.example1;

import java.util.Optional;

/*import java.util.List;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bookservice {
	
	@Autowired
	BookRepository bookrepository;
	/*
	 * @Autowired private ApplicationCommnadRunner runner;
	 */
	public Iterable<Book> findAll() {
		
		/* System.out.println ("Books" + books); */
		
		return bookrepository.findAll();
	}
	
	/*
	 * public Book addBookToH2(Book book) {
	 * 
	 * bookrepository.save(book);
	 * 
	 * return book; }
	 */
public void save(Book book) {
		
		bookrepository.save(book);
		
		
	}
	
	 public String findAndDeleteByTitle(String title ) {
		 String response = "";
		 Optional<Book> bookFound = bookrepository.findByTitle(title);
		if (bookFound.isPresent()) {

			bookrepository.delete(bookFound.get());
			response += "book deleted";
		} else {

			response += "book not found";
		}

		return response;
	  }
	 
	 public void deleteById(String id) {

			// String response = "";

			bookrepository.deleteById(id);

		}

	 public String update(String id, Book book) {

			String response = "";
			Optional<Book> bookFound = bookrepository.findById(id);

			if (bookFound.isPresent()) {

				bookFound.get().setTitle(book.getTitle());
				bookrepository.save(bookFound.get());
				response += "book updated";

			} else {
				response += "book not found";
			}

			return response;

		}
	
	// other options
		public long count() {

			long quantity = bookrepository.count();

			return quantity;
		}

		public boolean existsById(String id) {

			boolean isBook = bookrepository.existsById(id);

			return isBook;
		}

		public Long countByLastname(String author) {

			long quantity = bookrepository.countByAuthor(author);

			return quantity;
		}

		public void deleteByLastname(String author) {

			bookrepository.deleteByAuthor(author);

		}
	 
}