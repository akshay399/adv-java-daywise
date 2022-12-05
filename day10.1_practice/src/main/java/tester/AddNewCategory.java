package tester;

import static utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;
import pojos.Category;

public class AddNewCategory {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			System.out.println("inside standalone");
			CategoryDaoImpl cDao = new CategoryDaoImpl();
			System.out.println("enter cat name");
			String cName = sc.nextLine();
			System.out.println("enter description");
			String cDesc = sc.nextLine();
			System.out.println(cName + "  " + cDesc);
			System.out.println(cDao.addNewCategory(new Category(cName, cDesc)));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
