package modelLayer;

public class Product {
	
	private int id;
	private String name;
	private String countryOrigin;
	private int stock;
	private int minStock;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
		
	public Product(int id, String name, double salesPrice) {
		this.id = id;
		this.name = name;
		this.salesPrice = salesPrice;
	}

	public Product(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the countryOrigin
	 */
	public String getCountryOrigin() {
		return countryOrigin;
	}

	/**
	 * @param countryOrigin the countryOrigin to set
	 */
	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the minStock
	 */
	public int getMinStock() {
		return minStock;
	}

	/**
	 * @param minStock the minStock to set
	 */
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	/**
	 * @return the purchasePrice
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * @return the salesPrice
	 */
	public double getSalesPrice() {
		return salesPrice;
	}

	/**
	 * @param salesPrice the salesPrice to set
	 */
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	/**
	 * @return the rentPrice
	 */
	public double getRentPrice() {
		return rentPrice;
	}

	/**
	 * @param rentPrice the rentPrice to set
	 */
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	

	
}
