package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import dao.ProductDao;
import model.Product;
import util.HibernateUtil;

public class ProductImpl implements ProductDao{ 
	protected OgmSessionFactory sessionFactory;

	public ProductImpl() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean addProduct(Product pr) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(pr);
			tr.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean updateProduct(Product pr) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(pr);
			tr.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return false;
	}

	public boolean deleteProduct(long id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(Product.class, id));
			tr.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return false;
	}

	public Product getProduct(long id) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			Product pr = session.find(Product.class, id);
			tr.commit();

			return pr;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		return null;
	}

	@Override
	public List<Product> getProducts(int skip, int limit) {
		
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			
			String query = " db.products.aggregate([{'$skip':"+skip+"},{'$limit':"+limit+"}])";
			List<Product> products = session
					.createNativeQuery(query, Product.class)
					.getResultList();
			
			tr.commit();

			return products;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
	}

	@Override
	public List<Product> getProductsByName(String name) {
		
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			
			String query = "select pr from Product pr where pr.name = :x";  //JPQL
			
//			String query = " db.products.find({product_name:'"+name+"'})";
			
			List<Product> products = session
					.createQuery(query, Product.class)
					.setParameter("x", name)
					.getResultList();
			
			tr.commit();

			return products;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
	}

//	db.products.aggregate([{'$match':{'brand_id':{$eq:1}}},{$project:{_id:0, product_name:1}}])
	@Override
	public List<String> getProductsByBrand(int brandId) {
		List<String> names = new ArrayList<String>();
		
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			
			String query = "db.products.aggregate([{'$match':{'brand_id':{$eq:1}}}])";
			
			List<?> list = session
					.createNativeQuery(query)
					.getResultList();
			
			for(Object obj : list) {
				Object[] o = (Object[]) obj;
				names.add((String)o[1]);
			}
			
			tr.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return names;
	}

	
	
}
