package com.nagarro.springazure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.springazure.entity.Employee;
import com.nagarro.springazure.service.EmployeeService;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return service.getAllEmployees();
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<HttpStatus> deletEmployee(@PathVariable int id){
		try {
			this.service.deleteEmployee(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
