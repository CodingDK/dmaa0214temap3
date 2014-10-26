package modelLayer;
/**
 * A GunReplica Object Class
 * 
 * @author Group 3
 */
public class GunReplica extends Product {

	private String fabric;
	private String calibre;

	/**
	 * Instantiates a new GunReplica object.
	 */
	public GunReplica() {
		fabric = null;
		calibre = null;
	}

	/**
	 * Gets the fabric.
	 *
	 * @return the fabric
	 */
	public String getFabric() {
		return fabric;
	}

	/**
	 * Sets the fabric.
	 *
	 * @param fabric the fabric to set
	 */
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	/**
	 * Gets the calibre.
	 *
	 * @return the calibre
	 */
	public String getCalibre() {
		return calibre;
	}

	/**
	 * Sets the calibre.
	 *
	 * @param calibre the calibre to set
	 */
	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}
}
