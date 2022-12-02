package beans;
import java.util.List;

import dao.ProductDaoImpl;
import pojos.Product;
public class ProductBean {
	private ProductDaoImpl productDao;
	//def constructor: invoked by wc and trigger to call this is jsp:useBean
	public ProductBean() {
		productDao = new ProductDaoImpl();
		System.out.println("product dao and bean created");
	}
	
	//businness logic for getting all the products from the dao layer
	//business logic must be public(one of the disadvantages)
	public List<Product> fetchProducts(){
		System.out.println("In bl, fetchProducts()");
		List<Product> prod  = productDao.listAllProducts();
		return prod;
	}
}
