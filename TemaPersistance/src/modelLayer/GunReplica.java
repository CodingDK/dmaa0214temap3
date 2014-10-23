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
	public GunReplica(int id, String name, double salesPrice, String fabric, String calibre, boolean hidden) {
		super(id, name, salesPrice, hidden);
		this.fabric = fabric;
		this.calibre = calibre;
	}
	
	public GunReplica(){
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
