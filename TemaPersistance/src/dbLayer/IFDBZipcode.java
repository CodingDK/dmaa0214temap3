package dbLayer;

public interface IFDBZipcode {
	
	public Zipcode getZipcode(int zip);
	
	public int updateOrInsertZipcode(Zipcode zipObj);
	
	public int deleteZipcode(Zipcode zipObj);
	
}
