package com.nagarro.springazure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.springazure.entity.Employee;
import com.nagarro.springazure.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee e = repo.getOne(id);
		repo.delete(e);
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
