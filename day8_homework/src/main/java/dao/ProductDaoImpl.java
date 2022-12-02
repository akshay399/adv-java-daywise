package dao;
import static utils.HibernateUtils.getSessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Product;
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
	public Product getProductById(Integer id) {
		Product p = null;
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {
			p = session.get(Product.class, id);
			txn.commit();
		}catch(RuntimeException e){
			if(txn!=null)
				txn.rollback();
			throw e;
		}
		return p;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = null;
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {	
			String jpql = "Select p from pojos.Product p";
			list = session.createQuery(jpql, Product.class).getResultList();
			txn.commit();
		}catch(RuntimeException e){
			if(txn!=null)
				txn.rollback();
			throw e;
		}
		return list;
	}

	@Override
	public List<Product> getFilteredProducts(char c, double price) {
		List<Product> list = null;
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {
			System.out.println(c + " " + price);
//			like "a%"
			String l = "'" + c +"%'";
			String jpql = "select p from Product p where p.name like :chr and p.price<:prc";
			list = session.createQuery(jpql, Product.class).setParameter("chr", l).setParameter("prc", price).getResultList();
			System.out.println(list);
			txn.commit();
		}catch(RuntimeException e) {
			System.out.println("failed");
			if(txn!=null)
				txn.rollback();
			throw e;
		}
		return list;
	}

	@Override
	public void singleUpdate(Integer id) {
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {
			Product p = session.get(Product.class, id);
			System.out.println("persistent product from db present in both l1 cache and db ofc" + p );
			p.setPrice(p.getPrice() + 10000);
			p.setInStock(false);
			txn.commit();
		}catch(RuntimeException e) {
			if(txn!=null)
				txn.rollback();
			System.out.println("in catch block, update failed");
			throw e;
		}
	}


}





