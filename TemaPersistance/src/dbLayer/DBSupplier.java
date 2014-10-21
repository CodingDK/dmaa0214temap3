package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Supplier;

public class DBSupplier implements IFDBSupplier {
	private Connection con;
	
	public DBSupplier() {
		con = DBConnection.getInstance().getDBCon();
	}

	public ArrayList<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Supplier findSupplierByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertSupplier(Supplier sp) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateEmployee(Supplier sp) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeSupplier(Supplier sp) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private ArrayList<Supplier> miscWhere(String wQuery, boolean retAsso){
		ResultSet rs;
		ArrayList<Supplier> list = new ArrayList<Supplier>();
		
		String query = buildQuery(wQuery);
		
		try{
			
		}catch(Exception e){
			System.out.println("Query exception - Select: " + e);
		}
		
		
		return null;
	}

	private String buildQuery(String wQuery) {
		String query = "SELECT * FROM SUPPLIER "
					 + "JOIN ZIPCODES "
					 + "ON SUPPLIER.zipcode = zipcodes.zipcode";
		
		if(!wQuery.isEmpty()){
			query = query + " WHERE " + wQuery;
		}
		
		return query;
	}
	
	private Supplier buildSupplier(ResultSet rs){
		Supplier supObj = null;
		
		try{
			supObj = new Supplier(rs.getInt("supplierID"), rs.getString("name"), rs.getString("phone"));
			supObj.setAddress(rs.getString("address"));
			supObj.setCountry(rs.getString("country"));
			supObj.setEmail(rs.getString("email"));
			supObj.setCity(rs.getString("city"));
			supObj.setZipcode(rs.getInt("zipcode"));
		}catch(Exception e){
			System.out.println("Error building Supplier Object");
			e.printStackTrace();
		}
		
		
		return supObj;
	}
	
}
