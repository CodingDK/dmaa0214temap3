package modelLayer;
/**
 * A Part of an Order
 * @author Group 3
 *
 */
public class PartOrder {
	
	private Order parent;
	private int amount;
	private double unitPrice;
	private Product product;
	
	/**
	 * Create a PartSale object
	 * @param amount The amount of the product
	 * @param unitPrice The unit price for the product
	 * @param product The product too add
	 */
	public PartOrder() {}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the parent
	 */
	public Order getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Order parent) {
		this.parent = parent;
	}
	
	
	
	
}
