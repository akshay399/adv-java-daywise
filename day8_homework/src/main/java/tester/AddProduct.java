package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import pojos.Product;

import static utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;
public class AddProduct {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			Product p = null;
			
				for(int i = 0; i<4; i++) {
					ProductDaoImpl pDao = new ProductDaoImpl();
					System.out.println("Enter details to register a new product");
					System.out.println("name,price,description,expDate(yyyy-mm-dd)");
					String name = sc.next();
					double price = sc.nextDouble();
					String description = sc.next();
					LocalDate expDate = LocalDate.parse(sc.next());
					p = new Product(name, price, description, expDate,true);
					System.out.println(pDao.insertNewProduct(p));
					
				}
			
		}
	}
}
