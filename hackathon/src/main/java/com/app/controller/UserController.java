package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.User;
import com.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/login")
	public String showLogin() {
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String processLogin(@RequestParam String email, @RequestParam String password, Model map, HttpSession session) {
		try {
			User user = userService.authenticateUser(email, password); 
			session.setAttribute("user_details", user);
			map.addAttribute("msg", "logged in successfully");
			return "/user/menu_board";
			
		}catch(RuntimeException e) {
			System.out.println(e);
			map.addAttribute("msg", "unsuccessfull login :(");
			
			return "/user/login";
		}
	}
}
