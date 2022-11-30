package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import pojo.Product;

import static utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;
public class AddNewProduct {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			Product p = null;
			ProductDaoImpl pDao = new ProductDaoImpl();
			System.out.println("Enter details to register a new product");
			System.out.println("name,price,description,expDate(yyyy-mm-dd)");
//			p = new Product(sc.next(), sc.nextDouble(), sc.next(), LocalDate.parse(sc.next()));
			String name = sc.next();
			double price = sc.nextDouble();
			String description = sc.next();
			LocalDate expDate = LocalDate.parse(sc.next());
			if(LocalDate.now().isAfter(expDate)) {
				System.out.println("The product has been expired.");
			}else {
				p = new Product(name, price, description, expDate,true);
			 System.out.println(pDao.insertNewProduct(p));
			}
		}
	}
}
