package modelLayer;
/**
 * A GunReplica Object
 * @author Group 3
 *
 */
public class GunReplica extends Product {
	
	private String fabric;
	private String calibre;

	/**
	 * Create a GunReplica object
	 * @param name
	 * @param salesPrice
	 * @param fabric
	 * @param calibre
	 */
	public GunReplica(String name, double salesPrice, String fabric, String calibre) {
		super(name, salesPrice);
		this.fabric = fabric;
		this.calibre = calibre;
	}

	/**
	 * @return the fabric
	 */
	public String getFabric() {
		return fabric;
	}

	/**
	 * @param fabric the fabric to set
	 */
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	/**
	 * @return the calibre
	 */
	public String getCalibre() {
		return calibre;
	}

	/**
	 * @param calibre the calibre to set
	 */
	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}
}
