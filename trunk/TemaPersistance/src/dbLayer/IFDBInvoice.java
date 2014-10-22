package dbLayer;

import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;

public interface IFDBInvoice {
	
	/**
	 * get all Invoices
	 * @param retAsso
	 * @return
	 */
	public ArrayList<Invoice> getAllInvoices(boolean retAsso);
	
	/**
	 * Get Invoices by Customer
	 * @param customer
	 * @return
	 */
	public ArrayList<Invoice> getInvoicesByCustomer(Customer customer);
	
	/**
	 * Insert a new Invoice
	 * @param invoice
	 * @return
	 */
	public int insertInvoice(Invoice invoice);
	
	/**
	 * Update a Invoice
	 * @param invoice
	 * @return
	 */
	public int updateInvoice(Invoice invoice);
	
	/**
	 * Remove Invoice
	 * @param invoice
	 * @return
	 */
	public int removeInvoice(Invoice invoice);
	
}
