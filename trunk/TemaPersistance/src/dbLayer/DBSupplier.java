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
		return miscWhere("");
	}

	public ArrayList<Supplier> findSuppliersByName(String name) {
		return miscWhere("name LIKE '" + name + "'");
	}
	
	public ArrayList<Supplier> findSuppliersByPhone(String phone) {
		return miscWhere("phone = '" + phone + "'");
	}
	
	public Supplier findSuppliersByID(int id) {
		return singleWhere("supplierID = " + id);
	}
	
	public int insertSupplier(Supplier sp) throws Exception {
		int rc = -1;
		
		String query = "INSERT INTO SUPPLIER(name, address, country, phone, email, zipcode) VALUES ('" +
				        sp.getName() + "','" + 
				        sp.getAddress() + "','" + 
				        sp.getCountry() + "','" + 
				        sp.getPhone() + "','" + 
				        sp.getEmail() + "'," +
				        sp.getZipcode() + ");";
		
		System.out.println("Insert - Supplier : " + query);
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			
			stmt.close();
			
			sp.setId(getLatestID());
		}catch(Exception e){
			System.out.println("Error Inserting new Supplier : ");
			e.printStackTrace();
		}
		
		return rc;
	}

	public int updateEmployee(Supplier sp) {
		int rc = -1;
		
		String query = "UPDATE SUPPLIER SET " +
					   "name = ?, " + 
					   "address = ?, " + 
					   "country = ?, " + 
					   "phone = ?, " + 
					   "email = ?, " + 
					   "zipcode = ? " + 
					   "WHERE supplierID = ?;";
		
		try{
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, sp.getName());
			stmt.setString(2, sp.getAddress());
			stmt.setString(3, sp.getCountry());
			stmt.setString(4, sp.getPhone());
			stmt.setString(5, sp.getEmail());
			stmt.setInt(6, sp.getZipcode());
			stmt.setInt(7, sp.getId());
			
			rc = stmt.executeUpdate();
			
			stmt.close();
		}catch(Exception e){
			System.out.println("Error Updating Supplier : ");
			e.printStackTrace();
		}
		return 0;
	}

	public int removeSupplier(Supplier sp) {
		int rc = -1;
		
		String query = "DELETE FROM SUPPLIER WHERE SUPPLIERID = " + sp.getId() + ";";
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}catch(Exception e){
			System.out.println("Error Deleting supplier : ");
			e.printStackTrace();
		}
		
		return rc;
	}
	
	private Supplier singleWhere(String wQuery){
		ResultSet rs;
		Supplier supObj = null;
		String query = buildQuery(wQuery);
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rs = stmt.executeQuery(query);
			
			if(rs.next()){
				supObj = buildSupplier(rs);
			}
		}catch(Exception e){
			System.out.println("Query exception - Single Select: ");
			e.printStackTrace();
		}
		
		return supObj;
	}
	
	private ArrayList<Supplier> miscWhere(String wQuery){
		ResultSet rs;
		ArrayList<Supplier> list = new ArrayList<Supplier>();
		
		String query = buildQuery(wQuery);
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				Supplier supObj = buildSupplier(rs);
				list.add(supObj);
			}
			
			stmt.close();
		}catch(Exception e){
			System.out.println("Query exception - Misc Select: ");
			e.printStackTrace();
		}
		
		
		return list;
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
			supObj = new Supplier();
			supObj.setId(rs.getInt("supplierID"));
			supObj.setName(rs.getString("name"));
			supObj.setPhone(rs.getString("phone"));
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
	
	private int getLatestID(){
		int id = -1;
		ResultSet rs = null;
		
		String query = "SELECT IDENT_CURRENT( 'SUPPLIER' );";
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rs = stmt.executeQuery(query);
			
			if(rs.next()){
				id = rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println("Error getting the latest ID");
			e.printStackTrace();
		}
		
		
		return id;
	}
	
}