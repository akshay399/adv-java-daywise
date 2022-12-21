package com.app.daos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{
	List<Employee> findAll();
//3. Get all  emps from a specific dept joined after a particular date
	List<Employee> findBydeptNameAndJoinDateGreaterThan(String deptName, LocalDate date);
}
