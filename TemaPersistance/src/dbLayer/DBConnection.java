package dbLayer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DBConnection {
	private static final String driver = "jdbc:sqlserver://balder.ucn.dk";
	private static final String dbName = ";databaseName=dmaa0214TemaP_3";

	private static String userName = "; user=dmaa0214TemaP_3";
	private static String password = ";password=Biksemad";

	private DatabaseMetaData dma;
	private static Connection con;

	private static DBConnection instance;

	/**
	 * Initial Connection to Database
	 * 
	 * @throws NullPointerException
	 */
	public DBConnection() throws NullPointerException {
		String url = driver + dbName + userName + password;

		// Loading driver
		try {
			System.out.println("Loading drivers");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Loading class OK!");
		} catch (Exception e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}

		// Connection to DB

		try {
			con = DriverManager.getConnection(url);
			dma = con.getMetaData();
			System.out.println("Conection to " + dma.getURL());
			System.out.println("Driver " + dma.getDriverName());
			System.out.println("Database product name "
					+ dma.getDatabaseProductName());
			System.out.println("-----");
			System.out.println("Connection Successfully established");
		} catch (Exception e) {
			System.out.println("Error while connecting to the Database");
			e.printStackTrace();
			throw new NullPointerException("Error DBConnection");
		}

	}

	/**
	 * Closing the Connection
	 */
	public static void closeConnection() {
		try {
			con.close();
			System.out.println("Connection closed!");
		} catch (Exception e) {
			System.out.println("Error closing the connection: "
					+ e.getMessage());
		}
	}

	/**
	 * Get the Database Connection
	 * 
	 * @return Connection
	 */
	public Connection getDBCon() {
		return con;
	}

	/**
	 * Get instance of DBConnection
	 * 
	 * @return DBConnection
	 */
	public static DBConnection getInstance() {
		if (instance == null) {
			try {
				instance = new DBConnection();
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				instance = null;
			}
		}

		return instance;
	}

	/**
	 * Starting Transaction
	 */
	public static void startTransaction() {
		try {
			con.setAutoCommit(false);
		} catch (Exception e) {
			System.out.println("Error starting Transaction: " + e.getMessage());
		}
	}

	/**
	 * Commiting Transaction
	 */
	public static void commitTransaction() {
		try {
			con.setAutoCommit(true);
		} catch (Exception e) {
			System.out
					.println("Error commiting Transaction: " + e.getMessage());
		}
	}

	/**
	 * Rollback Transaction
	 */
	public static void rollBackTransaction() {
		try {
			con.rollback();
			con.setAutoCommit(true);
		} catch (Exception e) {
			System.out.println("Error executing Rollback on transaction "
					+ e.getMessage());
		}
	}

}
