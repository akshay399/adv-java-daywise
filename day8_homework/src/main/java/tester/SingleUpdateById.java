package tester;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;

import static utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;
public class SingleUpdateById {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			ProductDaoImpl pDao = new ProductDaoImpl();
			System.out.println("enter id to update price");
			pDao.singleUpdate(sc.nextInt());
		}
	}
}
