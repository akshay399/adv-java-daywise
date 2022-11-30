package dao;
import static utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Product;
public class ProductDaoImpl implements ProductDao {

	@Override
	public String insertNewProduct(Product product) {
		String message="";
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {
			session.save(product);
			txn.commit();
			message="Product added successfull!";
		}catch(RuntimeException e) {
			if(txn!=null)
				txn.rollback();
			message= "Addition unsuccesfull";
		}
		return message;
	}

	@Override
	public Product findById(Integer id) {
		Product p = null;
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {
			p = session.get(Product.class, id);
		}catch(RuntimeException e) {
			if(txn!=null)
				txn.rollback();
		}
		return p;
	}

}
