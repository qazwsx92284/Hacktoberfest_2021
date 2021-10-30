package com.myleec.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myleec.models.Employee;

@Service
public class EmployeeService {
	private List <Employee> employeeRepository = new ArrayList<Employee>();
	
	public List get_all_employees() {
		return employeeRepository;
	}
	
	public Employee get_employee_by_id(Long id) {
		for(Employee employee : employeeRepository) {
			if(employee.getEmpId() == id) {
				return employee;
			}
		}
		return null;
	}
	
	public Employee add_employee(Employee emp) {
		employeeRepository.add(emp);
		return emp;
	}
	
	public void delete_emplooyee(Long id) {
		for(Employee emp: employeeRepository) {
			if(emp.getEmpId() == id) {
				int index = employeeRepository.indexOf(emp);
				employeeRepository.remove(index);
			}
		}
	}
}
