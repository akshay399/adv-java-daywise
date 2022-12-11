package com.app.service;

import java.util.Date;
import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	String saveEmployee(Employee e);

	List<Employee> getFilteredEployees(String deptName, Date date);

	List<Employee> getFilteredEmployeeByName(String deptName);

	List<Employee> findBySalRangeService(Double salary);
}
