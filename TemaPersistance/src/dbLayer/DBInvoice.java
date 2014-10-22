package dbLayer;

import java.sql.Connection;
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
		ArrayList<Invoice> retInvoice = null;
		String strIDs = "";
		for(Order o : orders) {
			if(!strIDs.isEmpty()) {
				strIDs += ",";
			}
			strIDs += o.getInvoice().getInvoiceID();
		}
		if(strIDs.isEmpty()) {
			retInvoice = new ArrayList<Invoice>();
		}
		else {
			retInvoice = miscWhere("invoiceID IN (" + strIDs + ")");
		}
		return retInvoice;
	}

	@Override
	public Invoice getInvoiceByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	private ArrayList<Invoice> miscWhere(String wQuery) {
		ArrayList<Invoice> retList = new ArrayList<Invoice>();
		
		try {
			
		}
		catch(Exception e) {
			System.out.println("Query exception - select: " + e);
		}
		return retList;
	}

}
