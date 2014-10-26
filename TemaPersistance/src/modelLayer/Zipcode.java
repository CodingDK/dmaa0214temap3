package modelLayer;

/**
 * A Zipcode Object Class.
 * 
 * @author Group 3
 */
public class Zipcode {

	private int zipcode;
	private String city;

	/**
	 * Instantiates a new zipcode object.
	 *
	 * @param zipcode the zipcode
	 * @param city the city
	 */
	public Zipcode(int zipcode, String city) {
		this.zipcode = zipcode;
		this.city = city;
	}

	/**
	 * Gets the zipcode.
	 *
	 * @return the zipcode
	 */
	public int getZipcode() {
		return zipcode;
	}

	/**
	 * Sets the zipcode.
	 *
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
}
