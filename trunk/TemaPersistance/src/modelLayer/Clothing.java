package modelLayer;
// TODO: Auto-generated Javadoc

/**
 * A Clothing Object Class.
 *
 * @author Group 3
 */
public class Clothing extends Product {

	private String size;
	private String colour;

	/**
	 * Instantiates a new clothing object.
	 */
	public Clothing() {
		size = null;
		colour = null;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Gets the colour.
	 *
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * Sets the colour.
	 *
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
}
