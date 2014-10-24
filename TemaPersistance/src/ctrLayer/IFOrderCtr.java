package ctrLayer;

import java.util.ArrayList;

import ctrLayer.exceptions.NotEnoughStockException;
import modelLayer.Customer;
import modelLayer.PartOrder;
import modelLayer.Product;

public interface IFOrderCtr {
	
	public void createOrder(ArrayList<PartOrder> poList, Customer cust, boolean invoice);
	
	public ArrayList<Product> getProductsByName(String productName);
	
	public ArrayList<Product> getProductsByType(String type);
	
	public Product getProductByID(int id);
	
	public PartOrder createPartOrder(Product product, int amount, double unitPrice) throws NotEnoughStockException;
	
	/**
	 * Search for a customer by name
	 * @param customerName The name to search for
	 * @return The found customer object
	 */	
	public ArrayList<Customer> searchCustomerByName(String customerName);

	public ArrayList<Customer> searchCustomerByPhone(String phone);
	
	public Customer searchCustomerByID(int customerID);
	
	
}
