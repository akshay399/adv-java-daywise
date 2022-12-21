package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.EmployeeDao;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public String addEmployee(Employee e) {
		Employee emp = employeeDao.save(e);
		if(emp!=null) return "Employee added successfully!";
		return "Addition unsuccessfull!";
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public List<Employee> filteredEmployee(String deptName, LocalDate date) {
		return employeeDao.findBydeptNameAndJoinDateGreaterThan(deptName, date);
	}

}
