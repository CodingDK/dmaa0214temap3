package modelLayer;

public class Equipment extends Product {
	
	private String type;
	private String description;
	
	public Equipment(int id, String name, double salePrice, String type, boolean hidden) {
		super(id, name, salePrice, hidden);
		this.type = type;
	}

	public Equipment() {
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
