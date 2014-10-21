package modelLayer;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	
	private int ordreID;
	private Date date;
	private String deliveryStatus;
	private Date deliveryDate;
	private Invoice invoice;
	private ArrayList<PartOrder> partOrders;
	private Customer customer;
	/**
	 * @param ordreID
	 * @param date
	 * @param deliveryStatus
	 * @param deliveryDate
	 * @param invoice
	 * @param partOrders
	 * @param customer
	 */
	public Order(int ordreID, Date date, String deliveryStatus,
			Date deliveryDate, Invoice invoice, ArrayList<PartOrder> partOrders,
			Customer customer) {
		this.ordreID = ordreID;
		this.date = date;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.invoice = invoice;
		this.partOrders = partOrders;
		this.customer = customer;
	}
	
	/**
	 * @return the ordreID
	 */
	public int getOrdreID() {
		return ordreID;
	}
	/**
	 * @param ordreID the ordreID to set
	 */
	public void setOrdreID(int ordreID) {
		this.ordreID = ordreID;
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
	 * @return the deliveryStatus
	 */
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	/**
	 * @param deliveryStatus the deliveryStatus to set
	 */
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	/**
	 * @return the deliveryDate
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	/**
	 * @return the invoice
	 */
	public Invoice getInvoice() {
		return invoice;
	}
	/**
	 * @param invoice the invoice to set
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	/**
	 * @return the partOrders
	 */
	public ArrayList<PartOrder> getPs() {
		return partOrders;
	}
	/**
	 * @param partOrders the partOrders to set
	 */
	public void setPs(ArrayList<PartOrder> partOrders) {
		this.partOrders = partOrders;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
