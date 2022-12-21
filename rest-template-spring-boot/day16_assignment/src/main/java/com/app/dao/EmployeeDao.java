package com.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Employee;
//Get all  emps from a specific dept joined after a particular date

public interface EmployeeDao extends JpaRepository<Employee, Long> {
	List<Employee> findByMyDeptAndSalaryGreaterThan(String deptName, Date date);
	List<Employee> findByMyDept(String deptName);
//	4. Get emp id , first name , last name of all emps earning sal < some sal
//	@Query("SELECT new com.app.pojos.Employee(e.firstName, e.lastName) from com.app.pojos.Employee e where e.salary<?1")
//	@Query("SELECT e from com.app.pojos.Employee e where e.salary<?1")
	@Query(value="SELECT * from Employees where salary<:sal", nativeQuery = true)
	List<Employee> findBySalRange(@Param("sal") Double salary);
}
