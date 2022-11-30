package tester;
import static utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojo.Role;
import pojo.User;
public class RegisterNewUser {
	public static void main(String[] args) {
		System.out.println("inside main of register tester");
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter user details:   firstName,   lastName,   email,   "
					+ "password,  confirmPassword,   role,\r\n"
					+ "		  regAmount,   regDate(yyyy-MM-DD)");
			User newUser = new User(sc.next(), sc.next(), sc.next(), 
					sc.next(), sc.next(),Role.valueOf(sc.next().toUpperCase()) , sc.nextDouble(), LocalDate.parse(sc.next()) 
					);
			System.out.println(dao.registerUser(newUser));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
