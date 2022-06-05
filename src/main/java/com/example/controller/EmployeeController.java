package com.example.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.model.Employee;
import com.example.service.EmployeeService;





@Controller
public class EmployeeController {

//@Autowired(required=false)
@Autowired
private EmployeeService es;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp=es.getAllEmployee();
		m.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmployee(Model m) {
		Employee emp=new Employee();
		m.addAttribute("emp", emp);
		System.out.println("Hi Salim You Are Called");
		System.out.println(emp);
		return "add_employee";
	}
	
	 
	
	@PostMapping("/register")
	public String regiEmployee(@ModelAttribute("e") Employee e,HttpSession session)
	{
		//System.out.println("Hi Salim You Are Called");
		//System.out.println(e);
		
		es.saveEmp(e);
		session.setAttribute("msg", "Employee Added Successfully....");
		
		return "redirect:/";
	
	
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m)
	{
		Employee e=es.getEmployeeById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee e,HttpSession session) {
		es.saveEmp(e);
		session.setAttribute("msg", "Employee Data Updated Successfully...");
		return "redirect:/";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id,HttpSession session) {
		
		es.deleteEmployeeById(id);
		session.setAttribute("msg", "Employee Data deleteded Successfully...");
		return "redirect:/";
		
	}

}
