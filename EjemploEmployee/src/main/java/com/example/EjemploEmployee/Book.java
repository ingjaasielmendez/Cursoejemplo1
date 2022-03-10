package com.example.EjemploEmployee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	private String id;
	private String title;
	@Size(min=5,  max = 20)
	private String author;
	private int pages;
	@Min(value = 1000, message = "min year is in this case 1000")
	private int year;
	private String ISBN;
	
	
	
	
	public Book() {
	
	}
	
	public Book(String id, String title, String author, int pages, int year, String iSBN) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.year = year;
		ISBN = iSBN;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", pages=" + pages + ", year=" + year
				+ ", ISBN=" + ISBN + "]";
	}
	
	
	
	
	
}
