package com.myleec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myleec.models.Employee;
import com.myleec.services.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public List get_all_emps() {
		return empService.get_all_employees();
	}
	
	@GetMapping("/{id}")
	public Employee get_emp_by_id(@PathVariable Long id) {
		return empService.get_employee_by_id(id);
	}
	
	@PostMapping
	public Employee add_emp(@RequestBody Employee emp) {
		return empService.add_employee(emp);
	}
	
	@DeleteMapping("{id}")
	public void delete_emp(@PathVariable Long id) {
		empService.delete_emplooyee(id);
	}
	
}
