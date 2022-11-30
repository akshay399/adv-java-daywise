package tester;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojo.User;

import static utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;
public class RegisterNewUser {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			UserDaoImpl uDao = new UserDaoImpl();
			System.out.println("enter name and roll number");
			User details = new User(sc.next(), sc.nextInt());
			System.out.println(uDao.registerNewUser(details));
		}
	}
}
