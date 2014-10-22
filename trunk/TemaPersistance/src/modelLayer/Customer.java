package modelLayer;
/**
 * A Customer Object
 * @author Group 3
 *
 */
public class Customer {
	
	private int id;
	private String name;
	private String address;
	private Zipcode zipcode;
	private String phone;
	private boolean hidden = false;
	
	/**
	 * Create a Customer object
	 */
	public Customer() {
		
	}
	/**
	 * Create a Customer object
	 * @param id the id of the Customer
	 */
	public Customer(int id){
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the zipcode
	 */
	public Zipcode getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(Zipcode zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the hidden
	 */
	public boolean isHidden() {
		return hidden;
	}
	/**
	 * @param hidden the hidden to set
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
}
