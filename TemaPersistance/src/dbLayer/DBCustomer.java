package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import modelLayer.Customer;
import modelLayer.Zipcode;

public class DBCustomer implements IFDBCustomer {

	private Connection conn;
	
	public DBCustomer() {
		conn = DBConnection.getInstance().getDBCon();
	}

	
	public ArrayList<Customer> getAllCustomers() {
		return miscWhere("hidden=0");
	}

	
	public ArrayList<Customer> findCustomerByName(String name) {
		return miscWhere("hidden=0 AND name Like '%" + name + "%'");
	}

	
	public ArrayList<Customer> findCustomerByPhone(String phone) {
		return miscWhere("hidden=0 AND phone Like '%" + phone + "%'");
	}

	
	public Customer getCustomerByID(int id) {
		return singleWhere("customerID = " + id);
	}

	
	public int insertCustomer(Customer cust) {
		int rc = -1;
		int zipInsert = new DBZipcode().updateOrInsertZipcode(cust.getZipcode());
		if(zipInsert != -1) {
			try {
				String query = "INSERT INTO CUSTOMER"
						+ " (name, address, zipcode, phone) VALUES "
						+ "(?,?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setQueryTimeout(5);
				stmt.setString(1, cust.getName());
				stmt.setString(2, cust.getAddress());
				stmt.setInt(3, cust.getZipcode().getZipcode());
				stmt.setString(4, cust.getPhone());
				rc = stmt.executeUpdate();
						
				ResultSet genRs = stmt.getGeneratedKeys();
				if (genRs.next()) {
					cust.setId(genRs.getInt(1));
					//System.out.println("GeneratedID: " + genRs.getInt(1));
				} 
				stmt.close();
			}
			catch(Exception e) {
				System.out.println("Customer is not inserted correct");
				e.printStackTrace();
			}
		}
		return rc;
	}

	
	public int updateCustomer(Customer cust) {
		int rc = -1;
		int zipInsert = new DBZipcode().updateOrInsertZipcode(cust.getZipcode());
		if(zipInsert != -1) {
			try {
				Zipcode zipOldObj = getCustomerByID(cust.getId()).getZipcode();
				String query="UPDATE CUSTOMER SET"
						+ " name = ?,"
						+ " address = ?,"
						+ " zipcode = ?,"
						+ " phone = ?,"
						+ " hidden = ?"
						+ " WHERE customerID=?";
				//System.out.println(query);
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setQueryTimeout(5);
				stmt.setString(1, cust.getName());
				stmt.setString(2, cust.getAddress());
				stmt.setInt(3, cust.getZipcode().getZipcode());
				stmt.setString(4, cust.getPhone());
				stmt.setBoolean(5, cust.isHidden());
				stmt.setInt(6, cust.getId());
		 	 	rc = stmt.executeUpdate();
		 	 	stmt.close();
		 	 	
		 	 	new DBZipcode().removeZipcode(zipOldObj);
		 	 	
			}
			catch(Exception e) {
				System.out.println("Update Customer failed");
				e.printStackTrace();
			}
		}
		return rc;
	}
	
	
	public int removeCustomer(Customer cust) {
		int rc = -1;
		try {
			String query = "DELETE FROM CUSTOMER WHERE customerID=" + cust.getId();
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		
			new DBZipcode().removeZipcode(cust.getZipcode());
		}
		catch(SQLServerException e) {
			// 547 foreign key error
			if(e.getErrorCode() == 547) {
				cust.setHidden(true);
				rc = updateCustomer(cust);
				System.out.println("Customer is now hidden");
			} else {
				e.printStackTrace();
			}
		}
		catch(Exception e) {
			System.out.println("Delete exception in customer table: "+e);
		}
		return rc;
	}
	
	private Customer singleWhere(String wQuery) {
		Customer cus = null;
		
		try {
			String query = buildQuery(wQuery);
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet results = stmt.executeQuery(query);
			if(results.next()) {
				cus = buildCustomer(results);
			}
		}
		catch(Exception e) {
			System.out.println("Query exception - select: " + e);
		}
		
		return cus;
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
			Zipcode zipObj = new Zipcode(results.getInt("zipcode"), results.getString("city"));
			cus.setZipcode(zipObj);
			cus.setPhone(results.getString("phone"));
			cus.setHidden(results.getBoolean("hidden"));
		}
		catch(Exception e) {
			cus = null;
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
