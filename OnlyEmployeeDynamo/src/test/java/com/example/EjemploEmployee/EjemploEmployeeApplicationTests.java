package com.example.EjemploEmployee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.EjemploEmployee.Clases.Author;
import com.example.EjemploEmployee.Clases.Employee;
import com.example.EjemploEmployee.Servs.AuthorService;
import com.example.EjemploEmployee.Servs.EmployeeService;
import com.github.javafaker.Faker;

@SpringBootTest
class EjemploEmployeeApplicationTests {

	@Autowired
	EmployeeService employeeservice;
	@Autowired
	AuthorService authorservice;
	
	@Test
	 void testDeleteAllAuthors() { 
		 authorservice.deleteAll();
	}
	@Test
	void testCreateAuthor() {
		
		Author author1 = new Author ( "1", "Tolstoi", "Rusia", 1896, 12, false);
		Author author2 = new Author ( "2", "V Wolf", "EEUU", 235, 16, true);
		Author author3 = new Author ( "3", "Anna", "España", 2, 20, true);

		authorservice.save(author1);
		authorservice.save(author2);
		authorservice.save(author3);
		
	}
	
	/*
	 * @Test void testCreateCustomer() {
	 * 
	 * Employee employee = new Employee(); employee.setId("EMP000");
	 * employee.setName("Pedro"); employee.setSurname("Perez"); employee.setAge(55);
	 * employeeservice.save(employee);
	 * 
	 * }
	 */

	/*
	 * @Test void testCreateCustomers() { Faker faker = new Faker(); for (int i = 2;
	 * i <51; i++) { Employee employee = new Employee(); employee.setId("EMP00" +
	 * i); employee.setName(faker.name().firstName());
	 * employee.setSurname(faker.name().lastName());
	 * employee.setAge(faker.number().numberBetween(18, 65));
	 * employeeservice.save(employee); }
	 */
	@Test
	 void testDeleteAllCustomers() { 
		 employeeservice.deleteAll();
	 } 
	
	 }
	 
	 
	
