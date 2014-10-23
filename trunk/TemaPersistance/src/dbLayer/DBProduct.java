package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import modelLayer.Clothing;
import modelLayer.Equipment;
import modelLayer.GunReplica;
import modelLayer.Product;

public class DBProduct implements IFDBProduct {
	
	private Connection con;
	
	public DBProduct() {
		con = DBConnection.getInstance().getDBCon();
	}
	
	
	public ArrayList<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ArrayList<Product> searchProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Product getProductByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public int insertProduct(Product prod) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public int updateProduct(Product prod) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public int removeProduct(Product product) {
		int rp = -1;
		try {
			String query = "DELETE FROM PRODUCT WHERE productID = " + product.getId();
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rp = stmt.executeUpdate(query);
			stmt.close();
			}
		catch(SQLServerException e) {
			// 547 foreign key error
			if(e.getErrorCode() == 547) {
				product.setHidden(true);
				rp = updateProduct(product);
				System.out.println("Customer is now hidden");
			} else {
				e.printStackTrace();
			}
		}
		catch(Exception e) {
			System.out.println("Delete exception in customer table: "+e);
		}
		return rp;
	}
		
	public ArrayList<Product> miscWhere(String wQuery) {
		ArrayList<Product> products = null;
		try{
			
		}
		catch(Exception e) {
			System.out.println("Query exception - select: " + e);
		}
		return products;
	}
	
	public Product singleWhere(String wQuery){
		Product product = null;
		try{
			String query = buildQuery(wQuery);
			
		}
		catch(Exception e) {
			System.out.println("Query exception - select: " + e);
		}
		return product;
	}
	
	public Product buildProduct(ResultSet rs){
		Product retP = null;
		try{
			String type = rs.getString("type");
			if(type.equalsIgnoreCase("GunReplica")) {
				GunReplica product = new GunReplica();
				product.setCalibre(rs.getString("calibre"));
				product.setFabric(rs.getString("fabric"));
				retP = product;
			} else if(type.equalsIgnoreCase("Equipment")) {
				Equipment product = new Equipment();
				product.setType(rs.getString("type"));
				product.setDescription(rs.getString("description"));
				retP = product;
			} else if(type.equalsIgnoreCase("Clothing")) {
				Clothing product = new Clothing();
				product.setSize(rs.getString("size"));
				product.setColour(rs.getString("colour"));
				retP = product;
				
			} else if(type.equalsIgnoreCase("null")) {
				Product product = new Product();
				retP = product;
			} 
			retP.setName(rs.getString("name"));
			retP.setCountryOrigin(rs.getString("countryOrigin"));
			retP.setHidden(rs.getBoolean("hidden"));
			retP.setMinStock(rs.getInt("minStock"));
			retP.setPurchasePrice(rs.getDouble("purchasePrice"));
			retP.setRentPrice(rs.getDouble("rentPrice"));
			retP.setSalesPrice(rs.getDouble("salesPrice"));
			retP.setStock(rs.getInt("stock"));
		}
		catch(Exception e){
			System.out.println("Error in building product - " + e);
		}
		return retP; 
	}
	
	public String buildQuery(String wQuery) {
		String query = "SELECT * FROM Product";
		if(!wQuery.isEmpty()){
			query += " WHERE " + wQuery;
		}
		return query;
	}
}
