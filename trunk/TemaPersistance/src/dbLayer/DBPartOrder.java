package dbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelLayer.Order;
import modelLayer.PartOrder;

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
				pO.setAmount(amount);
				pO.setParent(parent);
				pO.setProduct(product);
				pO.setUnitPrice(unitPrice);
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
