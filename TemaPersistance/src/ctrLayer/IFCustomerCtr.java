
package ctrLayer;

import java.util.ArrayList;

import modelLayer.Customer;

public interface IFCustomerCtr {
	
	/**
	 * Search for a customer by name
	 * @param customerName The name to search for
	 * @return The found customer object
	 */
	public ArrayList<Customer> searchCustomerByName(String customerName);

	public ArrayList<Customer> searchCustomerByPhone(String phone);
	
	public Customer searchCustomerByID(int customerID);
	
	
}
