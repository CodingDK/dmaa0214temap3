package modelLayer;

import java.util.ArrayList;
import java.util.Date;

/**
 * An Order Object Class
 * 
 * @author Group 3
 */
public class Order {

	private int orderID;
	private Date date;
	private String deliveryStatus;
	private Date deliveryDate;
	private Invoice invoice;
	private ArrayList<PartOrder> partOrders;
	private Customer customer;

	/**
	 * Instantiates a new order object.
	 *
	 * @param orderID the order id
	 */
	public Order(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * Instantiates a new order object.
	 */
	public Order() {
	}

	/**
	 * Gets the order id.
	 *
	 * @return the ordreID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * Sets the order id.
	 *
	 * @param ordreID the ordreID to set
	 */
	public void setOrderID(int ordreID) {
		this.orderID = ordreID;
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
	 * Gets the delivery status.
	 *
	 * @return the deliveryStatus
	 */
	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	/**
	 * Sets the delivery status.
	 *
	 * @param deliveryStatus the deliveryStatus to set
	 */
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	/**
	 * Gets the delivery date.
	 *
	 * @return the deliveryDate
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * Sets the delivery date.
	 *
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * Gets the invoice.
	 *
	 * @return the invoice
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * Sets the invoice.
	 *
	 * @param invoice the invoice to set
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	/**
	 * Gets the ps.
	 *
	 * @return the partOrders
	 */
	public ArrayList<PartOrder> getPs() {
		return partOrders;
	}

	/**
	 * Sets the ps.
	 *
	 * @param partOrders the partOrders to set
	 */
	public void setPs(ArrayList<PartOrder> partOrders) {
		this.partOrders = partOrders;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
