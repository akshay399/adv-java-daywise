package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/customers")
public class CustomerController{
	//dependency service layer interfacte
	@Autowired
	private UserService userService;
	public CustomerController() {
		// TODO Auto-generated constructor stub
		System.out.println("in customer controller " + getClass());
	}
	
	//add request handling method to return list of customers
	@GetMapping
	public List<User> getAllCustomers(){
		System.out.println("in get all customer");
		return userService.getAllCustomers();
	}
}
