package com.example.example1;

/*import java.util.ArrayList;
import java.util.List;*/

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCommnadRunner implements CommandLineRunner {

	protected final Log logger = LogFactory.getLog(getClass());
	/* List<Book> books = new ArrayList<Book>(); */

	@Autowired
	Bookservice bookservice;
	@Autowired
	Authorservice authorservice;
	
	@Override
	public void run(String... args) throws Exception {

		logger.info("Welcome to the runner from commandLineRunner");
		// String id, String title, String author, int pages, int year, String iSBN
		Book book1 = new Book("U001", "Anna Karenina", "Tolstoi", 562, 1896, "BR5GV-5-ERG5-6567");
		Book book2 = new Book("U002", "To the lighthouse", "V Wolf", 235, 1626, "56756-DFGRT-554");
		Book book3 = new Book("U003", "Oralndo", "Virginia Wolf", 203, 2023, "4455645-GWR-456");
		Book book4 = new Book("U004", "In Search of Lost Time", "Marcel Proust", 152, 2023, "4455645-GWR-456");
		Book book5 = new Book("U005", "Time", "Marcel", 152, 2023, "44-GWR-456");
		// Book book4 = new Book ();
		// Book book5 = new Book ();
		// Book book6 = new Book ();
		/*
		 * books.add(book3); books.add(book2); books.add(book1); books.add(book4);
		 */

		/* logger.info("Books: " + books); */

		bookservice.save(book1);
		bookservice.save(book2);
		bookservice.save(book3);
		bookservice.save(book4);
		bookservice.save(book5);
	

	/*
	 * public List<Book> getBooks() { return books; }
	 */
	
		Author author1 = new Author ( 1, "Tolstoi", "Rusia", 1896, 12, false);
		Author author2 = new Author ( 2, "V Wolf", "EEUU", 235, 16, true);
		Author author3 = new Author ( 3, "Anna", "España", 2, 20, true);
		//Author author4 = new Author ();
		//Author author5 = new Author ();
		//Author author6 = new Author ();
		authorservice.addAuthorToH2(author1);
		authorservice.addAuthorToH2(author2);
		authorservice.addAuthorToH2(author3);
	}
}
