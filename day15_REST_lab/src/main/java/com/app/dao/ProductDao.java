package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;


public interface ProductDao extends JpaRepository<Product, Long>{
//add a method to fetch all products by specified category id
	//List<Product> getAllProductsByCategoryId(long categoryId);
	List<Product> findByProductCategoryId(long categoryId);
	List<Product> findAll();
}
