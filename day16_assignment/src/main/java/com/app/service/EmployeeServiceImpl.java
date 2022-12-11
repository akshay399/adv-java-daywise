package com.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao eDao; 
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return eDao.findAll();
	}
	@Override
	public String saveEmployee(Employee e) {
		try {
			Employee emp = eDao.save(e);	
			return "Employee added successfully";
		}catch(RuntimeException exp) {
			return "Adding unsuccessfull!!";
		}
		
	}
	@Override
	public List<Employee> getFilteredEployees(String deptName,Date date) {
		return eDao.findByMyDeptAndSalaryGreaterThan(deptName, date);
	}
	@Override
	public List<Employee> getFilteredEmployeeByName(String deptName) {
		// TODO Auto-generated method stub
		return eDao.findByMyDept(deptName);
	}
	@Override
	public List<Employee> findBySalRangeService(Double salary) {
		// TODO Auto-generated method stub
		List<Employee> list =  eDao.findBySalRange(salary);
		System.out.println("in service: " + list + " " + salary);
		return list;
	}

}
