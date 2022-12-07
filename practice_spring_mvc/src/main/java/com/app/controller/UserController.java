package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.UserService;

import pojos.User;

@Controller
@RequestMapping("/user") // optional CLASS LEVEL annotatiin but recommended for seperating user related
							// actions eg. sign signup login...etc
public class UserController {
	// dependency: service layer interface
	// controller injected with service layer
	@Autowired
	private UserService userService;

	public UserController() {
		// TODO Auto-generated constructor stub
		System.out.println("in user controller constructor");
	}

	// add request handling methhod to SHOW login form
//	@RequestMapping("/login") this will work to but getMapping will use get method only 
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login"; // handler returns this lvn to ds and ds forwards it to view resource and then
								// it returns actual view name i.e "WEB-INF/views/user(!!!!)/login.jsp"
								// (!!!)-> as we sperated user actions in control we also seperate user display
								// jsp pages
	}

	// as we have not mentioned any action in login.jsp the default action is the
	// same page. thereofore we are back here after dispacther and it looks for a
	// method having "/user/login" as key BUT with post method since we mentioned
	// method="post" in our form. we write postMapping mehtod to PROCESSFORM in the
	// same controller
	// =========================
	// add request handling method to PROCESS the form
	@PostMapping("/login") // equal to doPost
	// ===============
	// @RequestParam String email, @RequestParam String password->>> here the param
	// names is same as names in html formed we use.
	// @RequestParam: Method argument annotation to supply the binding between
	// request pparameter and method argument.
	// same as foll equivalent java code: String email =
	// request.getParameter("email")
	// @RequestParam(name="password") String pass. here "pass" is custom name which
	// does not match the request parameter name and hence to tell the container
	// that this is what our "password" in req par represents use "name="password"
	// attribute in @RequestParam
	// String pass = request.getParameter("password").
	public String processLogin(@RequestParam String email, @RequestParam(name = "password") String pass, Model map) {
		System.out.println("in process login");
		//call service layer method for user validation
		try { //try catch as we have used getSingleResult and it will throw error and not return a null value
			User user = userService.authenticateUser(email, pass); //user here is detached.
			//=>implies successfull login.
			map.addAttribute("msg", "Login successfull!!!").addAttribute("user_details", user);
			return "/user/details"; // avn returned from view resource: "WEB-INF/views/user(!!!!)/details.jsp"

		}catch(RuntimeException e) {
			System.out.println("err in process login form " + e);
			//=>implies invalid login -- add the error message here in the Model map
			map.addAttribute("msg", "Invalid login, please retry!!!");
			return "/user/login"; //AVN: WEB-INF/user/login.jsp... in case of invalid login we take the user back to login page
		}
			}
}
