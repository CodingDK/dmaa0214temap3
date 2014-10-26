package modelLayer;

/**
 * A Class for handling Customer objects
 * 
 * @author Group 3
 */
public class Customer {

	private int id;
	private String name;
	private String address;
	private Zipcode zipcode;
	private String phone;
	private boolean hidden = false;

	/**
	 * Create a Customer object.
	 */
	public Customer() {

	}

	/**
	 * Create a Customer object.
	 *
	 * @param id the id of the Customer
	 */
	public Customer(int id) {
		this.id = id;
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
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the zipcode.
	 *
	 * @return the zipcode
	 */
	public Zipcode getZipcode() {
		return zipcode;
	}

	/**
	 * Sets the zipcode.
	 *
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(Zipcode zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Checks if is hidden.
	 *
	 * @return the hidden
	 */
	public boolean isHidden() {
		return hidden;
	}
	
	/**
	 * Sets the hidden.
	 *
	 * @param hidden the hidden to set
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

}
