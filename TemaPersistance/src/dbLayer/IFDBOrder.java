package dbLayer;

import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;
import modelLayer.Order;

public interface IFDBOrder {

	// Get all Orders
	public ArrayList<Order> getAllOrders();

	// Get Orders by Invoice
	public ArrayList<Order> getOrdersByInvoice(Invoice invoice, boolean retAsso);

	// Get Orders by Customer
	public ArrayList<Order> getOrdersByCustomer(Customer customer,
			boolean retAsso);

	//
	public Order getOrderByID(int id, boolean retAsso);

	// Insert new Order
	public int insertOrder(Order order);

	// Update a Order
	public int updateOrder(Order order);

	// Remove Order
	public int removeOrder(Order order);

}
