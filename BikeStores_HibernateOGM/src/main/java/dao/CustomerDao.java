package dao;

import java.util.List;

import model.Customer;

public interface CustomerDao {
	public boolean addCustomer(Customer cus);
	public boolean updateCustomer(Customer cus);
	public boolean deleteCustomer(long id);
	public Customer getCustomer(long id);
	public List<Customer> getCustomers(int skip, int limit);
}
