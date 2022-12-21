package com.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
			System.out.println("0000000000 " + e.getMyDept());
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
	@Override
	public String deleteById(Long id) {
		Employee emp = eDao.findById(id).orElse(null);
		if(emp!=null) {
			eDao.delete(emp);
			return "Employee deleted successfully!";
		}else{
			return "Employee not found";
		} 
	}
	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Long id = emp.getId();
		Employee existingEmployee = eDao.findById(id).orElse(null);
		System.out.println("fetched employee: " + existingEmployee);	
		if(existingEmployee!=null) {
			existingEmployee = emp;
			return eDao.save(existingEmployee);
		}
		else
			return null;
	}

}
