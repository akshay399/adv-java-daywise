package tester;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import pojos.Product;

import static utils.HibernateUtils.getSessionFactory;

import java.util.List;
public class AllProducts {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory()){
			ProductDaoImpl pDao = new ProductDaoImpl();
			List<Product> list = pDao.getAllProducts();
			if(list == null) {
				System.out.println("No records to display.");
			}else {
				list.forEach(p->System.out.println(p));
			}
		}
	}
}	
