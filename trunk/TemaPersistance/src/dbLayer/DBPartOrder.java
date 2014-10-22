package dbLayer;

import java.sql.Connection;
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
	
	@Override
	public ArrayList<PartOrder> findPartOrders(Order order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int insertPartOrder(PartOrder pOrder) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updateEmployee(PartOrder pOrder) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int removePartOrder(PartOrder pORder) {
		// TODO Auto-generated method stub
		return 0;
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
					pO.setParent(dbO.getOrderByID(pO.getParent().getOrderID()));
					
					DBProduct dbP = new DBProduct();
					
				}
			}
		}catch(Exception e){
			System.out.println("Error Selecting PartOrder");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	private String buildQuery(String wQuery){
		String query = "SELECT * FROM PartOrder";
		
		if(!wQuery.isEmpty()){
			query = query + " WHERE " + wQuery;
		}
		
		return query;
	}
}
