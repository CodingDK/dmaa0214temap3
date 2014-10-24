package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;
import modelLayer.Order;
import modelLayer.PartOrder;

public class DBOrder implements IFDBOrder {
	private Connection con;
	
	public DBOrder() {
		con = DBConnection.getInstance().getDBCon();
	}
	
	
	public ArrayList<Order> getAllOrders() {
		return miscWhere("", false);
	}
	
	
	public ArrayList<Order> getOrdersByInvoice(Invoice invoice, boolean retAsso) {
		return miscWhere("invoiceID = " + invoice.getInvoiceID(), retAsso);
	}
	
	
	public ArrayList<Order> getOrdersByCustomer(Customer customer, boolean retAsso) {
		return miscWhere("customerID = " + customer.getId(), retAsso);
	}

	
	public Order getOrderByID(int id, boolean retAsso) {
		return singleWhere("orderID = " + id, retAsso);
	}
	
	
	public int insertOrder(Order order) {
		int rc = -1;
		String query = "INSERT INTO ORDERS (deliverYStatus, deliveryDate, invoiceID, customerID) VALUES (?,?,?,?)";
		ArrayList<PartOrder> orders = order.getPs();
		IFDBPartOrder dbPartOrder = new DBPartOrder();
		try{
			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, order.getDeliveryStatus());
			if(order.getDeliveryDate() != null){
				java.sql.Date da = new java.sql.Date(order.getDeliveryDate().getTime());
				stmt.setDate(2, da);
			}else{
				stmt.setNull(2, java.sql.Types.DATE);
			}
			
			if(order.getInvoice() != null){
				stmt.setInt(3, order.getInvoice().getInvoiceID());
			}else{
				stmt.setNull(3, java.sql.Types.INTEGER);
			}
			
			if(order.getCustomer() != null){
				stmt.setInt(4, order.getCustomer().getId());
			}else{
				stmt.setNull(4, java.sql.Types.INTEGER);
			}
			
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate();
			
			ResultSet genRs = stmt.getGeneratedKeys();
			if (genRs.next()) {
				order.setOrderID(genRs.getInt(1));
				System.out.println("GeneratedID: " + genRs.getInt(1));
			} 
			
			stmt.close();
			
			boolean completed = dbPartOrder.insertPartOrders(orders);
			
			if(!completed){
				rc = -1;
				removeOrder(order);
				System.out.println("Failed");
			}
		}catch(Exception e){
			System.out.println("Insert Order Failed : Order");
			e.printStackTrace();
		}
		
		return rc;
	}
	
	
	public int updateOrder(Order order) {
		int rc = -1;
		
		String query = "UPDATE ORDERS SET " +
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
	
	
	public int removeOrder(Order order) {
		int rc = -1;
		String query = "DELETE FROM ORDERS WHERE ORDERID = " + order.getOrderID();
		
		try{
			DBConnection.startTransaction();
			
			if(order.getPs() != null && order.getPs().size() > 0){
				IFDBPartOrder dbPartOrder = new DBPartOrder();
				for(PartOrder p : order.getPs()){
					System.out.println("Removing : " + p.getProduct().getId());
					System.out.println("Removing PartOrder : " + dbPartOrder.removePartOrder(p));
				}
			}
			
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
			
			DBConnection.commitTransaction();
		}catch(Exception e){
			DBConnection.rollBackTransaction();
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
					if(o.getCustomer() != null){
						IFDBCustomer dbC = new DBCustomer();
						o.setCustomer(dbC.getCustomerByID(o.getCustomer().getId()));
					}
					
					if(o.getInvoice() != null){
						IFDBInvoice dbI = new DBInvoice();
						o.setInvoice(dbI.getInvoiceByID(o.getInvoice().getInvoiceID()));
					}
					
					IFDBPartOrder dbPartOrder = new DBPartOrder();
					o.setPs(dbPartOrder.findPartOrders(o, true));
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
					
					IFDBPartOrder dbPartOrder = new DBPartOrder();
					o.setPs(dbPartOrder.findPartOrders(o, true));
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
