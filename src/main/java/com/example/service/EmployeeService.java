package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepo;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo er;
	
	
	
	public void saveEmp(Employee e)
	{
		this.er.save(e);
	}
	
	public List<Employee> getAllEmployee() {
		
		 return er.findAll();
	}
	
	public Employee getEmployeeById(int id)
	{
		Optional<Employee> e=er.findById(id);
		if(e.isPresent()) {
			return e.get();
			
		}
		return null;
	}
	
	
	public void deleteEmployeeById(int id) {
		er.deleteById(id);
	}
}
