package app;

import java.util.List;

import dao.ProductDao;
import dao.StaffDao;
import dao.impl.ProductImpl;
import dao.impl.StaffImpl;
import model.Product;

public class App {
	public static void main(String[] args) {
		
		StaffDao staffDao = new StaffImpl();
		ProductDao productDao = new ProductImpl();
		
		productDao.getProductsByBrand(1)
		.forEach(str -> System.out.println(str));
		
//		List<Product> ps = productDao.getProductsByName("Pure Cycles William 3-Speed - 2016");
//		
//		ps.forEach(pr -> System.out.println(pr));
		
//		productDao.getProducts(10, 10)
//		.forEach(pr -> System.out.println(pr));
		
		
		
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//				.applySetting(OgmProperties.ENABLED, true)
//				.configure()
//				.build();
//		
//		Metadata metadata = new MetadataSources(serviceRegistry)
//				.getMetadataBuilder()
//				.build();
//		
//		OgmSessionFactory sessionFactory  = metadata
//				.getSessionFactoryBuilder()
//				.unwrap(OgmSessionFactoryBuilder.class)
//				.build();
//		
//		OgmSession session = sessionFactory.getCurrentSession();
//		
//		Transaction tr = session.getTransaction();
//		
//		try {
//			tr.begin();
//			
//			tr.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tr.rollback();
//		}
		
	}
}
