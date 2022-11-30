package dao;

import pojo.User;
import static utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class UserDaoImpl implements UserDoa {

	@Override
	public String registerUser(User details) {
		Session hibSession = getSessionFactory().openSession();
		Transaction txn = hibSession.beginTransaction();
		try {
			hibSession.save(details);
			txn.commit();
		}catch(RuntimeException e) {
			System.out.println("Something went wrong");
			txn.rollback();
			throw e;
		}finally {
			hibSession.close();
		}
		return "user registered successfuly, name: " + details.getFirstName();
	}

}
