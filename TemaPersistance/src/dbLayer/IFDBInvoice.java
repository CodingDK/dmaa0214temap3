package dbLayer;

import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;

public interface IFDBInvoice {
	
	// get all Invoices
	public ArrayList<Invoice> getAllInvoices(boolean retAsso);
	
	// Get Invoices by Customer
	public ArrayList<Invoice> getInvoicesByCustomer(Customer customer);
	
	// Insert a new Invoice
	public int insertInvoice(Invoice invoice);
	
	// Update a Invoice
	public int updateInvoice(Invoice invoice);
	
	// Remove Invoice
	public int removeInvoice(Invoice invoice);
	
}
