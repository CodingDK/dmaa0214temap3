package modelLayer;

public class Clothing extends Product {
	
	private String size;
	private String colour;
	
	public Clothing(int id, String name, double salesPrice, String size) {
		super(id, name, salesPrice);
		this.size = size;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return super.getId();
	}
	
	
	
}
