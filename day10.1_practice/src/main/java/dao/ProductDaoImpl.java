package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Product;
import static utils.HibernateUtils.getSessionFactory;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addNewProduct(Product p) {
		String msg = null;
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {
			session.save(p);
			txn.commit();
		}catch(RuntimeException e) {
			if(txn!=null)
				txn.rollback();
			msg="adding product unsucessfull";
			throw e;
		}
		return msg;
	}

}
