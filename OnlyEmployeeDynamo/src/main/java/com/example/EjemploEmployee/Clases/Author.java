package com.example.EjemploEmployee.Clases;



import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "AuthorDB")
public class Author {
	
	private String id;
	public String name;
	public String country;
	public int dob;
	public int qtyBooks;
	public Boolean alive;
	
	
	
	public Author() {
		
	}



	public Author(String id, String name, String country, int dob, int qtyBooks, Boolean alive) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.dob = dob;
		this.qtyBooks = qtyBooks;
		this.alive = alive;
	}


	@DynamoDBAttribute
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}


	@DynamoDBHashKey(attributeName = "name")
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	@DynamoDBAttribute
	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}


	@DynamoDBAttribute
	public int getDob() {
		return dob;
	}



	public void setDob(int dob) {
		this.dob = dob;
	}


	@DynamoDBAttribute
	public int getQtyBooks() {
		return qtyBooks;
	}



	public void setQtyBooks(int qtyBooks) {
		this.qtyBooks = qtyBooks;
	}


	@DynamoDBAttribute
	public Boolean getAlive() {
		return alive;
	}



	public void setAlive(Boolean alive) {
		this.alive = alive;
	}



	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", country=" + country + ", dob=" + dob + ", qtyBooks="
				+ qtyBooks + ", alive=" + alive + "]";
	}
	
	
	
	
	
	

}
