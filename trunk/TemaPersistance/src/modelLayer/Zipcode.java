package modelLayer;

public class Zipcode {

	private int zipcode;
	private String city;

	/**
	 * @param zipcode
	 * @param city
	 */
	public Zipcode(int zipcode, String city) {
		this.zipcode = zipcode;
		this.city = city;
	}

	/**
	 * @return the zipcode
	 */
	public int getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode
	 *            the zipcode to set
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
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
}
