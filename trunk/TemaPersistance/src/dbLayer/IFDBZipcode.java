package dbLayer;

import modelLayer.Zipcode;

/**
 * The Interface for DBZipcode.
 */
public interface IFDBZipcode {

	/**
	 * Get a Zipcode object by a zipcode
	 *
	 * @param zip the zip
	 * @return the zipcode
	 */
	public Zipcode getZipcode(int zip);

	/**
	 * Update or insert zipcode object.
	 *
	 * @param zipObj the zipcode object
	 * @return numbers of affected rows or -1 if it's fail
	 */
	public int updateOrInsertZipcode(Zipcode zipObj);

	/**
	 * Remove a the zipcode object.
	 *
	 * @param zipObj the zipcode object
	 */
	public void removeZipcode(Zipcode zipObj);

}
