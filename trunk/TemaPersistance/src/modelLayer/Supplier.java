package modelLayer;

public class Supplier {
	
	private int idIterator = 1;
	private int id;
	private String name;
	private String address;
	private String country;
	private String phone;
	private String email;
	
	public Supplier(String name, String phone) {
		this.name = name;
		this.phone = phone;
		id = idIterator++;
	}

	public int getIdIterator() {
		return idIterator;
	}

	public void setIdIterator(int idIterator) {
		this.idIterator = idIterator;
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
	
}
