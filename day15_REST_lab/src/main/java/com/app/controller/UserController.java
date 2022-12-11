package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/all_users")
public class UserController {
	@Autowired
	private UserService userService;
	public UserController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctr of "  + getClass());
	}
	
	
	@GetMapping
	public List<User> getAllUsers(){
		System.out.println("in getAll method");
		return userService.getAllUsers();
	}
}
