package dbLayer;

import java.util.ArrayList;

import modelLayer.Customer;

public interface IFDBCustomer {

	/**
	 * Get all Customers
	 * 
	 * @return list of all none-hidden customers
	 */
	public ArrayList<Customer> getAllCustomers();

	/**
	 * Find Customers by name
	 * 
	 * @param name
	 * @return list of found none-hidden customers
	 */
	public ArrayList<Customer> findCustomerByName(String name);

	/**
	 * Find Customers by phone
	 * 
	 * @param phone
	 *            The phone to find by
	 * @return list of found none-hidden customers
	 */
	public ArrayList<Customer> findCustomerByPhone(String phone);

	/**
	 * Find a Customer by ID
	 * 
	 * @param id
	 *            The id of the Customer
	 * @return the found Customer
	 */
	public Customer getCustomerByID(int id);

	/**
	 * Insert a new Customer
	 * 
	 * @param cust
	 *            The Customer object to insert
	 * @return numbers of affected rows
	 */
	public int insertCustomer(Customer cust);

	/**
	 * Update a Customer
	 * 
	 * @param cust
	 *            The Customer object to update
	 * @return numbers of affected rows
	 */
	public int updateCustomer(Customer cust);

	/**
	 * Delete a Customer
	 * 
	 * @param cust
	 *            The Customer object to insert
	 * @return numbers of affected rows
	 */
	public int removeCustomer(Customer cust);

}
