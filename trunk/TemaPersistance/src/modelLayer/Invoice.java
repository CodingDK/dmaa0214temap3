package modelLayer;

import java.util.Date;

/**
 * An Invoice Object Class
 * 
 * @author Group 3
 */
public class Invoice {

	private int invoiceID;
	private Date date;

	/**
	 * Instantiates a new invoice object.
	 *
	 * @param invoiceID the invoice id
	 * @param date the date
	 */
	public Invoice(int invoiceID, Date date) {
		this.invoiceID = invoiceID;
		this.date = date;
	}

	/**
	 * Instantiates a new invoice object.
	 *
	 * @param id the id
	 */
	public Invoice(int id) {
		this.invoiceID = id;
	}

	/**
	 * Instantiates a new invoice.
	 */
	public Invoice() {

	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the invoice id.
	 *
	 * @return the invoiceID
	 */
	public int getInvoiceID() {
		return invoiceID;
	}

	/**
	 * Sets the invoice id.
	 *
	 * @param invoiceID the new invoice id
	 */
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

}
