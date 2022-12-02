package dao;

import java.util.List;

import pojos.Product;

public interface ProductDao {
	String insertNewProduct(Product p);
	Product getProductById(Integer id);
	List<Product> getAllProducts();
	
//	display all products whose names start from entered char value from user and price<specified price
	List<Product> getFilteredProducts(char c, double price);
	
	//update the price of given id
	void singleUpdate(Integer id);
}
