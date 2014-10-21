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
	private int zipcode;
	private String city;
	private String phone;
	/**
	 * A Customer object
	 * @param id The id of the Customer
	 * @param name The name of the Customer
	 * @param address The address of the Customer
	 * @param zipcode The zipcode of the Customer
	 * @param city The city of the Customer
	 * @param phone The phoneNumber of the Customer
	 */
	public Customer(int id, String name, String address, int zipcode,
			String city, String phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phone = phone;
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
	public int getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
}
