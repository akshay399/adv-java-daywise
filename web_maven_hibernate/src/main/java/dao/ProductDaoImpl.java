package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Product;
import static utils.HibernateUtils.getFactory;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> listAllProducts() {
		List<Product> products = null;
		String jpql = "Select p from Product p";
		Session hibSession = getFactory().getCurrentSession(); //getFac called for the first time here but on first req time and not on application deployement like we did in hib application in main based class with try w resorces we called getFactory
		//hence it is recommended to call getFactory so it gets called on application deployement time and we do this here using listener CONTEXT one
		Transaction txn = hibSession.beginTransaction();
		try {
			products = hibSession.createQuery(jpql, Product.class).getResultList();
			//products: list of persistent entities as part of both l1 cache and db
			txn.commit();
		}catch(RuntimeException e) {
			if(txn!=null)
				txn.rollback();
			throw e;
		}
		return products; //detached entity from l1 cache bcs of "txn.commit()" hib performs automatic dirty checking. - session.flush, no dml will be fired as it is just a select query. l1 cache is destroyed and cn returns to the pool
	}

}
