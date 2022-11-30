package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getSessionFactory;
public class Tester {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory()){
			Session hibSession = sf.getCurrentSession();
			System.out.println("in tester");
		}
	}
}
