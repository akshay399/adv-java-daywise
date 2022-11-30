package tester;
import static utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import pojo.Product;
public class FindProductById {
	public static void main(String[] args) {
		Product p = null;
		try(SessionFactory hibSession = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			ProductDaoImpl pDao = new ProductDaoImpl();
			System.out.println("Enter id to search the product");
			p = pDao.findById(sc.nextInt());
			if(p == null) {
				System.out.println("cant find the product!");
			}else {
				System.out.println(p);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
