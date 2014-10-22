package dbLayer;

import java.sql.ResultSet;
import java.sql.Statement;

import modelLayer.Zipcode;

public class DBZipcode implements IFDBZipcode {
	
	public DBZipcode() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Zipcode getZipcode(int zip) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int updateOrInsertZipcode(Zipcode zipObj) {
		
		Statement stmt = conn.createStatement();
		stmt.setQueryTimeout(5);
		String zipSelectQuery = "Select * from ZIPCODES where zipcode='" + cust.getZipcode() + "'";
		ResultSet results = stmt.executeQuery(zipSelectQuery);
		
		if(!results.next()) {
			String ZipInsertQuery = "Insert into ZIPCODES (zipcode, city) VALUES ("
				+ "'" + cust.getZipcode() + "','" + cust.getCity() + "');";		
			stmt.executeUpdate(ZipInsertQuery);
		}
		results.close();	
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int deleteZipcode(Zipcode zipObj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
