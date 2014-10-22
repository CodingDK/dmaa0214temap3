package dbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import modelLayer.Zipcode;

public class DBZipcode implements IFDBZipcode {
	private Connection con;
	
	public DBZipcode() {
		con = DBConnection.getInstance().getDBCon();
	}
	
	@Override
	public Zipcode getZipcode(int zip) {
		return singleWhere("zipcode = " + zip);
	}
	
	@Override
	public int updateOrInsertZipcode(Zipcode zipObj) {
		int rc = -1;
		
		if(getZipcode(zipObj.getZipcode()) != null){
			rc = updateZipcode(zipObj);
		}else{
			rc = insertZipcode(zipObj);
		}
		
		
		return rc;
	}
	
	@Override
	public void deleteZipcode(Zipcode zipObj) {
		String query = "DELETE FROM ZIPCODES WHERE zipcode = " + zipObj.getZipcode();
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(query);
			stmt.close();
		}catch(SQLServerException e) {
			if(e.getErrorCode() == 547) {
				System.out.println("ZipCode is used");
			} else {
				e.printStackTrace();
			}
		}catch(Exception e){
			System.out.println("Error Delete ZipCode");
			e.printStackTrace();
		}
	}
	
	private int insertZipcode(Zipcode zipObj){
		int rc = -1;
		
		String query = "INSERT INTO ZIPCODES(zipcode, city) VALUES (" + zipObj.getZipcode() + ", '" + zipObj.getCity() + "');";
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			
			stmt.close();
		}catch(Exception e){
			System.out.println("Error Inserting : ");
			e.printStackTrace();
		}
		
		return rc;
	}
	
	private int updateZipcode(Zipcode zipObj){
		int rc = -1;
		
		String query = "UPDATE ZIPCODES " +
					   "SET CITY = '" + zipObj.getCity() + "' " + 
					   "WHERE zipcode = " + zipObj.getZipcode();
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}catch(Exception e){
			System.out.println("Error Updating or Inserting Zipcode");
			e.printStackTrace();
		}
		
		
		return rc;
	}
	
	private Zipcode singleWhere(String wQuery){
		ResultSet rs;
		Zipcode zipObj = null;
		String query = "SELECT * FROM ZIPCODES WHERE " + wQuery;
		
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rs = stmt.executeQuery(query);
			
			if(rs.next()){
				zipObj = new Zipcode(rs.getInt("zipcode"), rs.getString("city"));
			}
			
			stmt.close();
		}catch(Exception e){
			System.out.println("Query Exception : Single Select: ");
			e.printStackTrace();
		}
		
		return zipObj;
	}
}
