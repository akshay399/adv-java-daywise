package tester;
import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory()){
			System.out.println("sf created hibernatte up and running");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
