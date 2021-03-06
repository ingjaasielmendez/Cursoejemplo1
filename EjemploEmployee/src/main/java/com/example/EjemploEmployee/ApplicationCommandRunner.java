package com.example.EjemploEmployee;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.EjemploEmployee.Clases.Author;
import com.example.EjemploEmployee.Clases.Book;
import com.example.EjemploEmployee.Servs.AuthorService;
import com.example.EjemploEmployee.Servs.BookService;

@Component
public class ApplicationCommandRunner implements CommandLineRunner {

	@Autowired
	BookService bookservice;
	
	@Autowired
	AuthorService authorservice;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	
	@Override
	public void run(String... args) throws Exception {
	
		logger.info("Welcome to the runner from commandLineRunner");
		// String id, String title, String author, int pages, int year, String iSBN
		Book book1 = new Book("U001", "Anna Karenina", "Tolstoi", 562, 1896, "BR5GV-5-ERG5-6567");
		Book book2 = new Book("U002", "To the lighthouse", "V Wolf", 235, 1626, "56756-DFGRT-554");
		Book book3 = new Book("U003", "Oralndo", "Virginia Wolf", 203, 2023, "4455645-GWR-456");
		Book book4 = new Book("U004", "In Search of Lost Time", "Marcel Proust", 152, 2023, "4455645-GWR-456");
		Book book5 = new Book("U005", "Time", "Marcel", 152, 2023, "44-GWR-456");
		

		bookservice.save(book1);
		bookservice.save(book2);
		bookservice.save(book3);
		bookservice.save(book4);
		bookservice.save(book5);
	

	
		Author author1 = new Author ( "1", "Tolstoi", "Rusia", 1896, 12, false);
		Author author2 = new Author ( "2", "V Wolf", "EEUU", 235, 16, true);
		Author author3 = new Author ( "3", "Anna", "España", 2, 20, true);

		authorservice.save(author1);
		authorservice.save(author2);
		authorservice.save(author3);
	}	
		
}
