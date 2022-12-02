package tester;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import pojos.Product;

import static utils.HibernateUtils.getSessionFactory;

import java.util.List;
import java.util.Scanner;
public class FilteredProducts {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			List<Product> list = null;
			ProductDaoImpl pDao = new ProductDaoImpl();
			System.out.println("enter a character");
			System.out.println("enter price");
			list = pDao.getFilteredProducts(sc.next().charAt(0), sc.nextDouble());
			if(list!=null)
				list.forEach(x->System.out.println(x));
			else {
				System.out.println("bad jpql");
			}
		}
	}
}
