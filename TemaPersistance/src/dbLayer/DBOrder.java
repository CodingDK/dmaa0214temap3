package dbLayer;

import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;
import modelLayer.Order;

public class DBOrder implements IFDBOrder {
	
	public DBOrder() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Order> getOrdersByInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Order> getOrdersByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int insertOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int removeOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
