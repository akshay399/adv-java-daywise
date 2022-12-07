package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeDao eDao;
	public EmployeeController() {
		// TODO Auto-generated constructor stub
		System.out.println("==in ctr of " + getClass());
	}
	
	@RequestMapping("/display")
	public String displayEmployee(@RequestParam long deptId, Model map) {
		System.out.println("delectde id: "  + deptId);
		List<Employee> list = eDao.fetchEmployees(deptId);
		map.addAttribute("employees", list);
		System.out.println(list);
		return "/employees/display";
	}
	
	
}
