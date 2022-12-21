package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	public EmployeeController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctr of " + getClass());
	}

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public String saveEmployee(@RequestBody Employee emp) {
		return employeeService.addEmployee(emp);
	}
	
	@GetMapping("/all_employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@GetMapping("/{deptName}/{join_date}")
	public List<Employee> getFilteredEmployees(@PathVariable @RequestBody String deptName ,@PathVariable @RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate join_date){
		return employeeService.filteredEmployee(deptName, join_date);
	}
}
