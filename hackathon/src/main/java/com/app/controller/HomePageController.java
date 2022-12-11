package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in def ctor " + getClass());
	}

	@RequestMapping("/")
	public String showIndexPage() {
		System.out.println("in show index page ");
		return "/index";
	}
}
