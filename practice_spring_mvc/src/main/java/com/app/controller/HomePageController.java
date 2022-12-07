package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandatory class level annotation to tell spring container following is a
			// request handlign controller = HANDLER
//singleton and eager Spring bean
public class HomePageController {
	public HomePageController() {
		System.out.println("in default constructor: " + getClass());
	}

	// add request handling method to forawrd the client to the index page.
	// output on client browser should be: Welcome to spring {server side dynamic
	// timestamp}
	@RequestMapping("/") // mandatory method level annotation, tells container wtvr follows is a ...
							// similar to service method in servlet
	public String showIndexPage(Model map) { // ioc since the sc automatically injects map empty and not null and
												// returns the map implicitly
		System.out.println("in show index page: " + map); // {}
		// Model addAttribute(String atrrName, Object attrValue
		map.addAttribute("server_ts", new Date());
		return "/index"; // handler explicitely returns LVM(logical view name) and implicitely sc returns
							// populated map TO THE DISPATCHER SERVLET(from where ds send lvm to view
							// resolver and view resolver further sends actual view
							// name("webINF/views/index.jsp")(open the spring-servlet.xml and observe
							// p:prefix..etc) to ds then ds checks for model attribute under request
							// scope(since forward) then it is forwaded to the view layer
	}
}
