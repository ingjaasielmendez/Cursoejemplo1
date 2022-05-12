package com.example.Restaurante.Clases;

import javax.persistence.Id;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
	public class CustomerImgQR {
		
		@Id
		private String id;
		private String username;
		private Binary image;
		
		
		
		public CustomerImgQR() {


		}



		public CustomerImgQR(String id, String username, Binary image) {
			super();
			this.id = id;
			this.username = username;
			this.image = image;
		}



		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}



		public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}



		public Binary getImage() {
			return image;
		}



		public void setImage(Binary image) {
			this.image = image;
		}



		@Override
		public String toString() {
			return "CustomerImgQR [id=" + id + ", username=" + username + ", image=" + image + "]";
		}
		
		
		
		
		
		
		
		
}
