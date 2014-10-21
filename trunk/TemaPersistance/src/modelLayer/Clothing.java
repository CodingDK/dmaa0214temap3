package modelLayer;

public class Clothing extends Product {
	
	private String size;
	private String colour;
	private static int idIterator = 1;
	private int id;
	
	public Clothing(String name, double salesPrice, String size) {
		super(name, salesPrice);
		this.size = size;
		id = idIterator++;
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
		return id;
	}
	
	
	
}
