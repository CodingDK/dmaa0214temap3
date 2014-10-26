package dbLayer;

import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;
import modelLayer.Order;
/**
 * The Interface for DBOrder.
 */
public interface IFDBOrder {

	/**
	 * Get all Orders
	 * @return List of all Orders in the system
	 */
	public ArrayList<Order> getAllOrders();

	/**
	 * Get Orders by Invoice
	 * @param invoice The invoice object to look for
	 * @param retAsso If true: include associations to other objects
	 * @return List of found orders
	 */
	public ArrayList<Order> getOrdersByInvoice(Invoice invoice, boolean retAsso);

	/**
	 * Get Orders by Customer
	 * @param customer The Customer object to look for
	 * @param retAsso If true: include associations to other objects
	 * @return List of found orders
	 */
	public ArrayList<Order> getOrdersByCustomer(Customer customer,
			boolean retAsso);

	/**
	 * Get an Order by id
	 * @param id The id of the order to look for
	 * @param retAsso If true: include associations to other objects
	 * @return The found Order object or null
	 */
	public Order getOrderByID(int id, boolean retAsso);

	/**
	 * Insert a new Order
	 * @param order The order object to insert
	 * @return numbers of affected rows or -1 if it's fail
	 */
	public int insertOrder(Order order);

	/**
	 * Update an order object
	 * @param order The order object to update
	 * @return numbers of affected rows or -1 if it's fail
	 */
	public int updateOrder(Order order);

	/**
	 * Remove an Order
	 * @param order The order object to remove
	 * @return numbers of affected rows or -1 if it's fail
	 */
	public int removeOrder(Order order);

}
