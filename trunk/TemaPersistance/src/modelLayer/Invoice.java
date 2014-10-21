package modelLayer;

import java.util.Date;

public class Invoice {
	
	private int InvoiceID;
	private Date date;
	
	/**
	 * @param invoiceID
	 * @param date
	 */
	public Invoice(int invoiceID, Date date) {
		InvoiceID = invoiceID;
		this.date = date;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the invoiceID
	 */
	public int getInvoiceID() {
		return InvoiceID;
	}
	
	
	
}
