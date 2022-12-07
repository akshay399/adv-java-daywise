package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;

@Controller

public class DepartmentController {
	@Autowired
	private DepartmentDao dDao;
	public DepartmentController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctr of " + getClass());
	}
	
	@RequestMapping("/")
	public String getDeptList(Model map) {
		List<Department> dept = dDao.fetchAllDepartment();
		System.out.println(dept);
		System.out.println("=========");
		dept.forEach(x->System.out.println(x));
		map.addAttribute("dept_list", dept);
		return "/dept";
	}
}
