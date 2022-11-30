package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojo.User;

import static utils.HibernateUtils.getSessionFactory;
public class UserDaoImpl implements UserDao {

	@Override
	public String registerNewUser(User details) {
			Session hibSession = getSessionFactory().getCurrentSession();
			Transaction txn = hibSession.beginTransaction();
			try {
				hibSession.save(details);
				txn.commit();
			}catch(RuntimeException e) {
				System.out.println("sOEMTHING WENT WRONG");
				txn.rollback();
			}
			finally {
				hibSession.close();
			}
			return "registration successfully" + details.getFirstName();
		}
	}


