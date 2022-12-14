package dao;

import pojos.User;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;
public class UserDaoImpl implements UserDao {
	@Override
	public String registerUser(User details) {
		//get session from SessionFactory(who is the provider of session)
		Session hibSession = getFactory().openSession();
		
		//begin a transaction.
		Transaction tx = hibSession.beginTransaction();
		try {
			hibSession.save(details);
			//at the last line of try means no error occured hence we commit the transaction.
			tx.commit();
		}catch(RuntimeException e) { //used runtime since this is an hibernate error and hibernate throws unchecked execption
			//implied some error occured.
			if(tx!=null) {
				tx.rollback();
			}
			//re throw the exception to the caller
			throw e;
		}finally {
			//close the session
			if(hibSession!=null) {
				hibSession.close();
			}
		}
		
		return "User registered with ID = " + details.getUserId();
	}
}
