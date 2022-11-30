package dao;

import pojo.Product;

public interface ProductDao {
	String insertNewProduct(Product product);
	Product findById(Integer id);
}
