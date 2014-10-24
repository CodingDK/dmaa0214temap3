package dbLayer;

import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;

public interface IFDBInvoice {

	/**
	 * Get all Invoices
	 * 
	 * @param retAsso
	 * @return
	 */
	public ArrayList<Invoice> getAllInvoices();

	/**
	 * Get Invoices by Customer
	 * 
	 * @param customer
	 * @return
	 */
	public ArrayList<Invoice> getInvoicesByCustomer(Customer customer);

	/**
	 * Get a Invoice by id
	 * 
	 * @param id
	 * @return
	 */
	public Invoice getInvoiceByID(int id);

	/**
	 * Insert a new Invoice
	 * 
	 * @param invoice
	 * @return
	 */
	public int insertInvoice(Invoice invoice);

	/**
	 * Update a Invoice
	 * 
	 * @param invoice
	 * @return
	 */
	public int updateInvoice(Invoice invoice);

	/**
	 * Remove Invoice
	 * 
	 * @param invoice
	 * @return
	 */
	public int removeInvoice(Invoice invoice);

}
