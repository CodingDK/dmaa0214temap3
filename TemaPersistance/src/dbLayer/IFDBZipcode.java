package dbLayer;

import modelLayer.Zipcode;

public interface IFDBZipcode {
	
	public Zipcode getZipcode(int zip);
	
	public int updateOrInsertZipcode(Zipcode zipObj);
	
	public void deleteZipcode(Zipcode zipObj);
	
}
