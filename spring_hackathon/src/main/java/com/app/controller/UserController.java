package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
	public UserController() {
		// TODO Auto-generated constructor stub
		System.out.println("in def ctr og user controller");
	}
	@GetMapping("/login")
	public String showLoginPage() {
		System.out.println("in show login method");
		return "/user/login";
	}
	@PostMapping("/login")
	public String processLogin(@RequestParam String email, @RequestParam String password) {
		System.out.println("emial: " + email + " pass: " + password);
		return "/user/login";
	}
}
