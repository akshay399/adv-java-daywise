package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductDao;
import com.app.pojos.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao pDao;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> p = pDao.findAll();
		System.out.println("---------------------------------");
		p.forEach(x->System.out.println(x));
		return p;
	}
	

}
