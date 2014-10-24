package modelLayer;

import java.util.Date;

public class Invoice {

	private int invoiceID;
	private Date date;

	/**
	 * @param invoiceID
	 * @param date
	 */
	public Invoice(int invoiceID, Date date) {
		this.invoiceID = invoiceID;
		this.date = date;
	}

	public Invoice(int id) {
		this.invoiceID = id;
	}

	public Invoice() {

	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the invoiceID
	 */
	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

}
