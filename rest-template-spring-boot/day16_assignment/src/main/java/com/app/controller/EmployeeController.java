 package com.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;
@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService eService;
	public EmployeeController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctr of employee " + getClass());
	}
	
	@PostMapping
	public String addEmployee(@RequestBody Employee emp) {
		System.out.println("1111" + emp.getFirstName());
		return eService.saveEmployee(emp);
	}
	
//	@CrossOrigin
	@GetMapping
	public List<Employee> getAllEmployees(){
		List<Employee> list = eService.getAllEmployees();
		return list;
	}
	@GetMapping("/{salary}")
	public List<Employee> findBySalRange(@PathVariable Double salary){
		System.out.println("inm " + salary);
		List<Employee> list = eService.findBySalRangeService(salary);
		System.out.println("in findbysalramgeL " + list + salary);
		return list;
	}
	@GetMapping("/id/{id}")
	public String deleteById(@PathVariable Long id) {
		System.out.println("idd " + id);
		return eService.deleteById(id);
	}
	@PutMapping
	public String updateEmployee(@RequestBody Employee emp) {
		System.out.println("in updateEmployee put mapping: " + emp + " " + emp.getId());
		Employee e = eService.updateEmployee(emp);
		if(e!=null)
			return "Update successfull";
		else
			return "Update failed";
	}
//	@GetMapping("/{deptName}/{date}")
//	public List<Employee> getFilteredEmployee( @PathVariable String deptName, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
//		System.out.println("dept name: " + deptName + " date: " + date );
//		return eService.getFilteredEployees(deptName, date);
//	}
//	@GetMapping("/{myDept}")
//	public List<Employee> getFilteredEmployee( @PathVariable String myDept){
//		System.out.println("dept name: " + myDept );
//		return eService.getFilteredEmployeeByName(myDept);
//	}
}
