package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		// TODO Auto-generated constructor stub
		System.out.println("in home controller.	");
	}
	@RequestMapping("/")
	public String showWelcomePage() {
		System.out.println("in method");
		return "/index";
	}
}
