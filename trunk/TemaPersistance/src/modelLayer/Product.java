package modelLayer;

/**
 * A Product Object Class.
 *
 * @author Group 3
 */
public class Product {

	private int id;
	private String name;
	private String countryOrigin;
	private int stock;
	private int minStock;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
	private Supplier supplier;
	private boolean hidden = false;

	/**
	 * Instantiates a new product object.
	 *
	 * @param id the id
	 */
	public Product(int id) {
		this.id = id;
	}

	/**
	 * Instantiates a new product.
	 */
	public Product() {
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the country origin.
	 *
	 * @return the countryOrigin
	 */
	public String getCountryOrigin() {
		return countryOrigin;
	}

	/**
	 * Sets the country origin.
	 *
	 * @param countryOrigin the countryOrigin to set
	 */
	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}

	/**
	 * Gets the stock.
	 *
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Sets the stock.
	 *
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Gets the min stock.
	 *
	 * @return the minStock
	 */
	public int getMinStock() {
		return minStock;
	}

	/**
	 * Sets the min stock.
	 *
	 * @param minStock the minStock to set
	 */
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	/**
	 * Gets the purchase price.
	 *
	 * @return the purchasePrice
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * Sets the purchase price.
	 *
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * Gets the sales price.
	 *
	 * @return the salesPrice
	 */
	public double getSalesPrice() {
		return salesPrice;
	}

	/**
	 * Sets the sales price.
	 *
	 * @param salesPrice the salesPrice to set
	 */
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	/**
	 * Gets the rent price.
	 *
	 * @return the rentPrice
	 */
	public double getRentPrice() {
		return rentPrice;
	}

	/**
	 * Sets the rent price.
	 *
	 * @param rentPrice the rentPrice to set
	 */
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Checks if is hidden.
	 *
	 * @return true, if is hidden
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * Sets the hidden.
	 *
	 * @param hidden the new hidden
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * Gets the supplier.
	 *
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * Sets the supplier.
	 *
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
