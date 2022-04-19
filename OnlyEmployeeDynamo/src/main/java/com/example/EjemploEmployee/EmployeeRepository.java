package com.example.EjemploEmployee;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.example.EjemploEmployee.Clases.Employee;



@EnableScan
public interface EmployeeRepository extends CrudRepository<Employee, String> {

	Optional<Employee> findById(String id);

	Iterable<Employee> findItemByName(String name);

}