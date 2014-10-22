package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		int rc = -1;
		String query = "INSERT INTO ORDER (deliverStatus, deliveryDate, invoiceID, customerID) VALUES (?,?,?,?)";
		
		try{
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, order.getDeliveryStatus());
			if(order.getDeliveryDate() != null){
				stmt.setDate(2, new java.sql.Date(order.getDeliveryDate().getTime()));
			}else{
				stmt.setNull(2, java.sql.Types.NULL);
			}
			
			if(order.getInvoice() != null){
				stmt.setInt(3, order.getInvoice().getInvoiceID());
			}else{
				stmt.setNull(3, java.sql.Types.NULL);
			}
			
			if(order.getCustomer() != null){
				stmt.setInt(4, order.getCustomer().getId());
			}else{
				stmt.setNull(4, java.sql.Types.NULL);
			}
			
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate();
			stmt.close();
		}catch(Exception e){
			System.out.println("Insert Order Failed : Order");
			e.printStackTrace();
		}
		
		return rc;
	}
	
	@Override
	public int updateOrder(Order order) {
		int rc = -1;
		
		String query = "UPDATE ORDER SET " +
					   "deliveryStatus = ?, " +
					   "deliveryDate = ?, " +
					   "invoiceID = ?, " +
					   "customerID = ? " +
					   "WHERE orderID = ?";
		try{
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setQueryTimeout(5);
			
			stmt.setString(1, order.getDeliveryStatus());
			if(order.getDeliveryDate() != null){
				stmt.setDate(2, new java.sql.Date(order.getDeliveryDate().getTime()));
			}else{
				stmt.setNull(2, java.sql.Types.NULL);
			}
			
			if(order.getInvoice() != null){
				stmt.setInt(3, order.getInvoice().getInvoiceID());
			}else{
				stmt.setNull(3, java.sql.Types.NULL);
			}
			
			if(order.getCustomer() != null){
				stmt.setInt(4, order.getCustomer().getId());
			}else{
				stmt.setNull(4, java.sql.Types.NULL);
			}
			
			stmt.setInt(5, order.getOrderID());
			
			rc = stmt.executeUpdate();
			
			stmt.close();
			
		}catch(Exception e){
			System.out.println("Update Order Error : Order");
			e.printStackTrace();
		}
		
		
		
		return rc;
	}
	
	@Override
	public int removeOrder(Order order) {
		int rc = -1;
		String query = "DELETE FROM ORDERS WHERE ORDERID = " + order.getOrderID();
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			
			stmt.close();
		}catch(Exception e){
			System.out.println("Error Remove Order : Order");
			e.printStackTrace();
		}
		
		return rc;
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
					if(o.getCustomer() != null){
						DBCustomer dbC = new DBCustomer();
						o.setCustomer(dbC.getCustomerByID(o.getCustomer().getId()));
					}
					
					if(o.getInvoice() != null){
						DBInvoice dbI = new DBInvoice();
						o.setInvoice(dbI.getInvoiceByID(o.getInvoice().getInvoiceID()));
					}
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
			int cusID = rs.getInt("customerID");
			if(cusID != 0){
				o.setCustomer(new Customer(cusID));
			}
			
			o.setDate(rs.getDate("orderDate"));
			o.setDeliveryDate(rs.getDate("deliveryDate"));
			o.setDeliveryStatus(rs.getString("deliveryStatus"));
			
			int invID = rs.getInt("invoiceID");
			if(invID != 0){
				o.setInvoice(new Invoice(invID));
			}
			
			o.setOrderID(rs.getInt("orderID"));
		}catch(Exception e){
			o = null;
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
