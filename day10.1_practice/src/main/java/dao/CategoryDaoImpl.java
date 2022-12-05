package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Category;

import static utils.HibernateUtils.getSessionFactory;
public class CategoryDaoImpl implements CategoryDao {
	@Override
	public String addNewCategory(Category category) {
		String msg = null;
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction(); 
		
		try {
			session.persist(category);
			msg = "Category added successfully :)";
			txn.commit();
		}catch(RuntimeException e) {
			e.printStackTrace();
			System.out.println("======================");
			if(txn!=null) {
				txn.rollback();
			}
			msg = "unsuccessfull :(";
		}
		return msg;
		
	}

	
	
}
