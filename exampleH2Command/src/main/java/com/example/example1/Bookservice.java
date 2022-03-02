package com.example.example1;

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
	public Iterable<Book> queryBook() {
		
		//System.out.println ("Books" + books);
		
		return bookrepository.findAll();
	}
	
	public Book addBookToH2(Book book) {
		
		bookrepository.save(book);
		
		return book;
	}
	
	/*
	 * public String deleteBookFromArray(String title ) {
	 * 
	 * int index = findBookByTilte(title); bookrepository.getBooks().remove(index);
	 * 
	 * return "Book deleted by title"; }
	 * 
	 * public String deleteBookFromArray(int index ) {
	 * 
	 * bookrepository.getBooks().remove(index);
	 * 
	 * return "Book deleted by index"; }
	 * 
	 * public int findBookByTilte(String title) {
	 * 
	 * int index = -1; for ( Book bookTemporal : bookrepository.getBooks()) {
	 * 
	 * if ( bookTemporal.getTitle().equals(title) ) { index =
	 * bookrepository.getBooks().indexOf(bookTemporal); } } return index; }
	 * 
	 * public Book replaceBook(int indexBook, Book book) {
	 * 
	 * bookrepository.getBooks().set(indexBook, book);
	 * 
	 * 
	 * return book;
	 * 
	 * }
	 * 
	 * public Book getBookByIndex (int index) {
	 * 
	 * Book book = bookrepository.getBooks().get(index);
	 * 
	 * return book; }
	 */
	
}