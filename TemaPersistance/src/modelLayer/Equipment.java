package modelLayer;
/**
 * A Equipment Object Class
 * 
 * @author Group 3
 */
public class Equipment extends Product {

	private String type;
	private String description;

	/**
	 * Instantiates a new Equipment object.
	 */
	public Equipment() {
		type = null;
		description = null;
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
