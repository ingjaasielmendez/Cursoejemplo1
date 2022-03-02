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
	
	@Override
	public void run(String... args) throws Exception {

		logger.info("Welcome to the runner from commandLineRunner");
		// String title, String author, int pages, int year, String iSBN
		Book book1 = new Book("Anna Karenina", "Tolstoi", 562, 1896, "BR5GV-5-ERG5-6567");
		Book book2 = new Book("To the lighthouse", "V Wolf", 235, 1626, "56756-DFGRT-554");
		Book book3 = new Book("Oralndo", "Virginia Wolf", 203, 2023, "4455645-GWR-456");
		Book book4 = new Book("In Search of Lost Time", "Marcel Proust", 152, 2023, "4455645-GWR-456");
		Book book5 = new Book("Time", "Marcel", 152, 2023, "44-GWR-456");
		// Book book4 = new Book ();
		// Book book5 = new Book ();
		// Book book6 = new Book ();
		/*
		 * books.add(book3); books.add(book2); books.add(book1); books.add(book4);
		 */

		/* logger.info("Books: " + books); */

		bookservice.addBookToH2(book1);
		bookservice.addBookToH2(book2);
		bookservice.addBookToH2(book3);
		bookservice.addBookToH2(book4);
		bookservice.addBookToH2(book5);
	}

	/*
	 * public List<Book> getBooks() { return books; }
	 */
	
	

}
