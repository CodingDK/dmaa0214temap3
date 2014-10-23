package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelLayer.Order;
import modelLayer.PartOrder;
import modelLayer.Product;

public class DBPartOrder implements IFDBPartOrder {
	private Connection con;
	
	public DBPartOrder() {
		con = DBConnection.getInstance().getDBCon();
	}
	
	
	public ArrayList<PartOrder> findPartOrders(Order order, boolean retAsso) {
		return miscWhere("ORDERID = " + order.getOrderID(), retAsso);
	}
	
	
	public int insertPartOrder(PartOrder pOrder) {
		int rc = -1;
		String query = "INSERT INTO PARTORDER (orderID, productID, amount, unitPrice) values (?,?,?,?)";
		
		try{
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setQueryTimeout(5);
			stmt.setInt(1, pOrder.getParent().getOrderID());
			stmt.setInt(2, pOrder.getProduct().getId());
			stmt.setInt(3, pOrder.getAmount());
			stmt.setDouble(4, pOrder.getUnitPrice());
			
			rc = stmt.executeUpdate();
			
			stmt.close();
		}catch(Exception e){
			System.out.println("Error Inserting : Part Order");
			e.printStackTrace();
		}
		
		
		return rc;
	}
	
	
	public int updatePartOrder(PartOrder pOrder) {
		int rc = -1;
		
		try{
			String query = "UPDATE PARTORDER SET"
					+ " productID = ?,"
					+ " amount = ?"
					+ " unitPrice = ?"
					+ " WHERE orderID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setQueryTimeout(5);
			stmt.setInt(1, pOrder.getProduct().getId());
			stmt.setInt(2, pOrder.getAmount());
			stmt.setDouble(3, pOrder.getUnitPrice());
			stmt.setInt(4, pOrder.getParent().getOrderID());
			rc = stmt.executeUpdate();
			stmt.close();
		}catch(Exception e){
			System.out.println("Error Updating : Part Order");
			e.printStackTrace();
		}
		
		return rc;
	}
	
	
	public int removePartOrder(PartOrder pOrder) {
		int rc = -1;
		String query = "DELETE FROM PARTORDER WHERE ORDERID = " + pOrder.getParent().getOrderID();
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}catch(Exception e){
			System.out.println("Query Exception : Remove Part Order");
			e.printStackTrace();
		}
		
		return rc;
	}
	
	private ArrayList<PartOrder> miscWhere(String wQuery, boolean retAsso){
		ArrayList<PartOrder> list = new ArrayList<PartOrder>();
		
		String query = buildQuery(wQuery);
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				PartOrder pO = new PartOrder();
				pO.setAmount(rs.getInt("amount"));
				pO.setParent(new Order(rs.getInt("orderid")));
				pO.setProduct(new Product(rs.getInt("productID")));
				pO.setUnitPrice(rs.getFloat("price"));
				if(retAsso){
					DBOrder dbO = new DBOrder();
					pO.setParent(dbO.getOrderByID(pO.getParent().getOrderID(), false));
					
					DBProduct dbP = new DBProduct();
					pO.setProduct(dbP.getProductByID(pO.getProduct().getId()));
				}
				
				list.add(pO);
			}
			
			stmt.close();
		}catch(Exception e){
			System.out.println("Error Selecting PartOrder");
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	private String buildQuery(String wQuery){
		String query = "SELECT * FROM PartOrder";
		
		if(!wQuery.isEmpty()){
			query = query + " WHERE " + wQuery;
		}
		
		return query;
	}
}
