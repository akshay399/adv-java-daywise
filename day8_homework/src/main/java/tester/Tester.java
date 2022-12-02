package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getSessionFactory;

public class Tester {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory()){
			System.out.println("inside tester");
		}
	}
}
