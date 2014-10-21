package dbLayer;

import java.sql.*;

public class DBConnection {
	private static final String driver = "jdbc:sqlserver://balder.ucn.dk";
	private static final String dbName = ";databaseName=dmaa0214TemaP_3";
	
	private static String userName = "; user=dmaa0214TemaP_3";
	private static String password = ";password=Biksemad";
	
	private DatabaseMetaData dma;
	private static Connection con;
	
	private static DBConnection instance;
	
	public DBConnection() {
		String url = driver + dbName + userName + password;
	}
	
}
