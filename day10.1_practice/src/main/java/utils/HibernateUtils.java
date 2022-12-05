package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
		System.out.println("in static init block");
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
