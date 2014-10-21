package dbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelLayer.Customer;

public class DBCustomer implements IFDBCustomer {

	private Connection conn;
	
	public DBCustomer() {
		conn = DBConnection.getInstance().getDBCon();
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		return miscWhere(" hidden=0");
	}

	@Override
	public ArrayList<Customer> findCustomerByName(String name) {
		return miscWhere(" hidden=0 AND name Like '%" + name + "%'");
	}

	@Override
	public ArrayList<Customer> findCustomerByPhone(String phone) {
		return miscWhere(" hidden=0 AND phone Like '%" + phone + "%'");
	}

	@Override
	public int insertCustomer(Customer cust) {
		int rc = -1;
		try {
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(5);
			String zipSelectQuery = "Select * from ZIPCODES where zipcode='" + cust.getZipcode() + "'";
			ResultSet results = stmt.executeQuery(zipSelectQuery);
			
			if(!results.next()) {
				String ZipInsertQuery = "Insert into ZIPCODES (zipcode, city) VALUES ("
					+ "'" + cust.getZipcode() + "','" + cust.getCity() + "');";		
				stmt.executeUpdate(ZipInsertQuery);
			}
			results.close();		
			String query = "INSERT INTO CUSTOMER"
				+ " (name, address, zipcode, phone) VALUES ("
				+ "'" + cust.getName() + "',"
				+ "'" + cust.getAddress() + "',"
				+ "'" + cust.getZipcode() + "',"
				+ "'" + cust.getPhone() + "')";
			//System.out.println("Query: " + query);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
					
			ResultSet genRs = stmt.getGeneratedKeys();
			if (genRs != null) {
				genRs.next();
				cust.setId(genRs.getInt(1));
				//System.out.println("GeneratedID: " + genRs.getInt(1));
			} 
			
		}
		catch(SQLException e) {
			System.out.println("Customer is not inserted correct");
			e.printStackTrace();
		}
		return rc;
	}

	@Override
	public int updateCustomer(Customer cust) {
		int rc = -1;
		
		try {
			String query="UPDATE CUSTOMER SET "
				+ "name = '" + cust.getName() + "',"
				+ "address = '" + cust.getAddress() + "',"
				+ "zipcode = '" + cust.getZipcode() + "',"
				+ "phone = '" + cust.getPhone() + "'"
				+ " WHERE customerID='" + cust.getId() + "'";
			Statement stmt = conn.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();	
		}
		catch(Exception e) {
			System.out.println("Update Customer failed");
			e.printStackTrace();
		}
		
		return rc;
	}
	
	@Override
	public int deleteCustomer(Customer cust) {
		int rc = -1;
		try {
			String query = "DELETE FROM CUSTOMER WHERE customerID='" + cust.getId() + "'";
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(Exception e) {
			System.out.println("Delete exception in department db: "+e);
		}
		return rc;
	}
	
	private ArrayList<Customer> miscWhere(String wQuery) {
		ArrayList<Customer> retList = new ArrayList<Customer>();
		
		try {
			String query = buildQuery(wQuery);
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet results = stmt.executeQuery(query);
			while(results.next()) {
				Customer cusObj = buildCustomer(results);
				if(cusObj != null) {
					retList.add(cusObj);
				}
			}
			results.close();
			stmt.close();
		}
		catch(Exception e) {
			System.out.println("Query exception - select: " + e);
		}
		return retList;
	}

	
	private Customer buildCustomer(ResultSet results) {
		Customer cus = new Customer();
		try {
			cus.setId(results.getInt("customerID"));
			cus.setName(results.getString("name"));
			cus.setAddress(results.getString("address"));
			cus.setCity(results.getString("city"));
			cus.setZipcode(results.getInt("zipcode"));
			cus.setPhone(results.getString("phone"));
			cus.setHidden(results.getBoolean("hidden"));
		}
		catch(Exception e) {
			System.out.println("error in building the customer object");
		}
		return cus;
	}

	private String buildQuery(String wQuery) {
		String query = "select * from CUSTOMER"
				+ " join ZIPCODES on"
				+ " CUSTOMER.zipcode=ZIPCODES.zipCode";
		if (!wQuery.isEmpty()) {
			query += " WHERE " + wQuery;
		}
		return query;
	}

}
