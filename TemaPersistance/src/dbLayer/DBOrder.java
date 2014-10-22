package dbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;
import modelLayer.Order;

public class DBOrder implements IFDBOrder {
	private Connection con;
	
	public DBOrder() {
		con = DBConnection.getInstance().getDBCon();
	}
	
	@Override
	public ArrayList<Order> getAllOrders() {
		return miscWhere("", false);
	}
	
	@Override
	public ArrayList<Order> getOrdersByInvoice(Invoice invoice, boolean retAsso) {
		return miscWhere("invoiceID = " + invoice.getInvoiceID(), retAsso);
	}
	
	@Override
	public ArrayList<Order> getOrdersByCustomer(Customer customer, boolean retAsso) {
		return miscWhere("customerID = " + customer.getId(), retAsso);
	}

	@Override
	public Order getOrderByID(int id, boolean retAsso) {
		return singleWhere("orderID = " + id, retAsso);
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
	
	private ArrayList<Order> miscWhere(String wQuery, boolean retAsso){
		ArrayList<Order> list = new ArrayList<Order>();
		String query = buildQuery(wQuery);
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				Order o = buildOrder(rs);
				if(retAsso){
					DBCustomer dbC = new DBCustomer();
					o.setCustomer(dbC.getCustomerByID(o.getCustomer().getId()));
					
					DBInvoice dbI = new DBInvoice();
					o.setInvoice(dbI.getInvoiceByID(o.getInvoice().getInvoiceID()));
				}
				
				list.add(o);
			}			
			
			stmt.close();
		}catch(Exception e){
			System.out.println("misc Where Failed : Order");
			e.printStackTrace();
		}
		
		return list;
	}
	
	private Order singleWhere(String wQuery, boolean retAsso){
		Order o = null;
		String query = buildQuery(wQuery);
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){
				o = buildOrder(rs);
				if(retAsso){
					DBCustomer dbC = new DBCustomer();
					o.setCustomer(dbC.getCustomerByID(o.getCustomer().getId()));
					
					DBInvoice dbI = new DBInvoice();
					o.setInvoice(dbI.getInvoiceByID(o.getInvoice().getInvoiceID()));
				}
			}			
			
			stmt.close();
		}catch(Exception e){
			System.out.println("misc Where Failed : Order");
			e.printStackTrace();
		}
		
		return o;
	}

	private Order buildOrder(ResultSet rs) {
		Order o = new Order();
		
		try{
			o.setCustomer(new Customer(rs.getInt("customerID")));
			o.setDate(rs.getDate("orderDate"));
			o.setDeliveryDate(rs.getDate("deliveryDate"));
			o.setDeliveryStatus(rs.getString("deliveryStatus"));
			o.setInvoice(new Invoice(rs.getInt("invoiceID")));
			o.setOrderID(rs.getInt("orderID"));
		}catch(Exception e){
			System.out.println("Building Order Failed : Order");
			e.printStackTrace();
		}
		
		
		return o;
	}

	private String buildQuery(String wQuery) {
		String query = "SELECT * FROM ORDERS";
		
		if(!wQuery.isEmpty()){
			query = query + " WHERE " + wQuery;
		}
		
		return query;
	}

}
