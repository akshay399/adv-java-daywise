package tester;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import pojos.Product;

import static utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;
public class ProductById {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			ProductDaoImpl pDao = new ProductDaoImpl();
			Product p = null;
			System.out.println("Enter the id of the product to search");
			p = pDao.getProductById(sc.nextInt());
			if(p == null)
				System.out.println("Product for the given id not found");
			else {
				System.out.println(p);
			}
		}
	}
}
