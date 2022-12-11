package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;
import com.app.service.ProductService;


@RestController
@RequestMapping("/all_products2")
public class ProductController {
	@Autowired
	private ProductService productService;
	public ProductController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ProductController controller " + getClass());
	}
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	} 
}
