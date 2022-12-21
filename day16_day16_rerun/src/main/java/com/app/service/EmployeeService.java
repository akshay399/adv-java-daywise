package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	String addEmployee(Employee e);
	List<Employee> getAllEmployees();
	List<Employee> filteredEmployee(String deptName, LocalDate date);
}
