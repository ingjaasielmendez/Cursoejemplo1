package com.example.example1;

/*import java.time.LocalDate;*/

import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.validation.constraints.Min;
/*import javax.validation.constraints.NotBlank;*/
/*import javax.validation.constraints.NotEmpty;*/
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Book {

	/*
	 * private String title; 
	 * private String author; 
	 * private int pages; 
	 * private int year; 
	 * private String ISBN; 
	 * private LocalDate createdat; 
	 * private Date
	 * datePublished;
	 */
	
	/* @NotBlank */
	@Id
	/* @GeneratedValue (strategy = GenerationType.IDENTITY) */
	private String id;
	private String title;
	@Size(min=5,  max = 20)
	private String author;
	private int pages;
	@Min(value = 1000, message = "min year is in this case 1000")
	private int year;
	@NotNull
	private String ISBN;
	/* private LocalDate createdat; */
	/*
	 * @NotEmpty private Date datePublished;
	 */
	//@Email
	//private String email
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "user") private User user;
	 */
	
	
	public Book () {}
	
	public Book(String id, String title, String author, int pages, int year, String ISBN) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.year = year;
		this.ISBN = ISBN;
		/* this.datePublished = datePublished; */
	
	}
	
	
	/*
	 * public Book(String title, String author, int pages, int year, String iSBN,
	 * LocalDate createdat, Date datePublished) { super(); this.title = title;
	 * this.author = author; this.pages = pages; this.year = year; this.ISBN = iSBN;
	 * this.createdat = createdat; this.datePublished = datePublished; }
	 */

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	/*
	 * public LocalDate getCreatedat() { return createdat; }
	 * 
	 * public void setCreatedat(LocalDate createdat) { this.createdat = createdat; }
	 * 
	 * public Date getDatePublished() { return datePublished; }
	 * 
	 * public void setDatePublished(Date datePublished) { this.datePublished =
	 * datePublished; }
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */
	/*
	 * @Override public String toString() { return "Book [title=" + title +
	 * ", author=" + author + ", pages=" + pages + ", year=" + year + ", ISBN=" +
	 * ISBN + ", User=" + user + "]"; }
	 */
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", pages=" + pages + ", year=" + year + ", ISBN=" + ISBN
				+ "]";
	}
	
	
}
