package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.CategoryDao;
import com.app.dao.ProductDao;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//dep : category dao i/f
	@Autowired
	private CategoryDao categoryDao;
	// dep : product dao i/f
	@Autowired
	private ProductDao productDao;
	
	public CustomerController() {
		System.out.println("in ctor of " + getClass());
	}
	//add req handling method to forward the clnt to show product categories to the clnt
	@GetMapping("/categories")
	public String showCustomerMainPage(Model map)
	{
		System.out.println("in show cust main page");
		map.addAttribute("category_list", categoryDao.getAllCategories());
		return "/customer/categories";//AVN : /WEB-INF/views/customer/categories.jsp
	}
	//URL : http://localhost:8080/day14_boot/customer/products?categoryId=2
	@GetMapping("/products")
	public String showProducts(@RequestParam long categoryId,Model map)
	{
		System.out.println("in show products "+categoryId);
		map.addAttribute("product_list", productDao.getAllProductsByCategoryId(categoryId));
		return "/customer/products";//AVN : /WEB-INF/views/customer/products.jsp
	}

}
