package com.app.dao;

import java.util.List;

import com.app.pojos.Product;

public interface ProductDao {
//add a method to fetch all products by specified category id
	List<Product> getAllProductsByCategoryId(long categoryId);
}
