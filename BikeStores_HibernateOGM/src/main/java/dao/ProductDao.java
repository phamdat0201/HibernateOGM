package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	public boolean addProduct(Product pr);
	public boolean updateProduct(Product pr);
	public boolean deleteProduct(long id);
	public Product getProduct(long id);
	
	public List<Product> getProductsByName(String name);
	public List<String> getProductsByBrand(int brandId);
	
	public List<Product> getProducts(int skip, int limit);
}
