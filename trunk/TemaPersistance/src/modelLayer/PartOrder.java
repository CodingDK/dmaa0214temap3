package modelLayer;

/**
 * A PartOrder Object Class.
 *
 * @author Group 3
 */
public class PartOrder {

	private Order parent;
	private int amount;
	private double unitPrice;
	private Product product;

	/**
	 * Create a PartSale object.
	 */
	public PartOrder() {
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Gets the unit price.
	 *
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Sets the unit price.
	 *
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets the product.
	 *
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public Order getParent() {
		return parent;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent the parent to set
	 */
	public void setParent(Order parent) {
		this.parent = parent;
	}

}
