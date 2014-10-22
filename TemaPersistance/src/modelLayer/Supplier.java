package modelLayer;

public class Supplier {
	
	private int id;
	private String name;
	private String address;
	private String country;
	private String phone;
	private String email;
	private Zipcode zipCode;
	
	public Supplier() {

	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	/**
	 * @return the zipCode
	 */
	public Zipcode getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(Zipcode zipCode) {
		this.zipCode = zipCode;
	}

	
	
	
	
}
