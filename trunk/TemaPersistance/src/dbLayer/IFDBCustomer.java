package dbLayer;

import java.util.ArrayList;

import modelLayer.Customer;

public interface IFDBCustomer {
	
	// Get all Customers
	public ArrayList<Customer> getAllCustomers();
	
	// Find Customers by name
	public ArrayList<Customer> findCustomerByName(String name);
	
	// Find Customers by phone
	public ArrayList<Customer> findCustomerByPhone(String phone);
	
	// Insert a new Customer
	public int insertCustomer(Customer cust);
	
	// Update a Customer
	public int updateCustomer(Customer cust);
}
