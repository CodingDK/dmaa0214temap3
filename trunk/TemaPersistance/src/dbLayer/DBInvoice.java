package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelLayer.Customer;
import modelLayer.Invoice;
import modelLayer.Order;

public class DBInvoice implements IFDBInvoice {
	
	private Connection conn;

	public DBInvoice() {
		conn = DBConnection.getInstance().getDBCon();
	}

	@Override
	public ArrayList<Invoice> getAllInvoices() {
		return miscWhere("");
	}

	@Override
	public ArrayList<Invoice> getInvoicesByCustomer(Customer customer) {
		ArrayList<Order> orders = new DBOrder().getOrdersByCustomer(customer, false);
		ArrayList<Invoice> retInvoice = new ArrayList<Invoice>();
		String strIDs = "";
		for(Order o : orders) {
			if(!strIDs.isEmpty()) {
				strIDs += ",";
			}
			strIDs += o.getInvoice().getInvoiceID();
		}
		if(!strIDs.isEmpty()) {
			retInvoice = miscWhere("invoiceID IN (" + strIDs + ")");
		}
		return retInvoice;
	}

	@Override
	public Invoice getInvoiceByID(int id) {
		return singleWhere("invoiceID = " + id);
	}

	@Override
	public int insertInvoice(Invoice invoice) {
		int rc = -1;
		try {
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(5);
			
			String query = "INSERT INTO INVOICE DEFAULT VALUES;";
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			ResultSet genRs = stmt.getGeneratedKeys();
			if(genRs.next()) {
				invoice.setInvoiceID(genRs.getInt(1));
			}
			stmt.close();		
		}
		catch(Exception e) {
			System.out.println("Invoice is not inserted correct");
			e.printStackTrace();
		}
		return rc;
	}

	@Override
	public int updateInvoice(Invoice invoice) {
		int rc = -1;
		try {
			String query = "UPDATE INVOICE SET"
				+ " invoiceDate = ?,"
				+ " WHERE invoiceID= ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setQueryTimeout(5);
			stmt.setDate(1, new java.sql.Date(invoice.getDate().getTime()));
			stmt.setInt(2, invoice.getInvoiceID());
			rc = stmt.executeUpdate();
			
			stmt.close();
		}
		catch(Exception e) {
			System.out.println("Update Invoice failed");
			e.printStackTrace();
		}
		return rc;
	}

	@Override
	public int removeInvoice(Invoice invoice) {
		int rc = -1;
		try {
			String query = "DELETE FROM INVOICE WHERE invoiceID=" + invoice.getInvoiceID();
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(Exception e) {
			System.out.println("Delete exception in invoice table: " + e);
		}
		return rc;
	}

	private Invoice singleWhere(String wQuery) {
		Invoice inv = null;
		
		try {
			String query = buildQuery(wQuery);
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				inv = buildInvoice(rs);
			}
		}
		catch(Exception e) {
			System.out.println("Query exception - select: " + e);
		}
		return inv;
	}

	private ArrayList<Invoice> miscWhere(String wQuery) {
		ArrayList<Invoice> retList = new ArrayList<Invoice>();
		
		try {
			String query = buildQuery(wQuery);
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Invoice invObj = buildInvoice(rs);
				if(invObj != null) {
					retList.add(invObj);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Query exception - select: " + e);
		}
		return retList;
	}

	private Invoice buildInvoice(ResultSet rs) {
		Invoice inv = null;
		try {
			inv = new Invoice(rs.getInt("invoiceID"), rs.getDate("invoiceDate"));
		}
		catch(Exception e) {
			inv = null;
			System.out.println("Error in building the invoice object");
			e.printStackTrace();
		}
		return inv;
	}

	private String buildQuery(String wQuery) {
		String query = "select * from INVOICE";
		if(!wQuery.isEmpty()) {
			query += " WHERE " + wQuery;
		}
		return query;
	}

}
