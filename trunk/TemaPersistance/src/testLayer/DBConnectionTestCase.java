package testLayer;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import dbLayer.DBConnection;

public class DBConnectionTestCase {
	
	@Before
	public void setUp() throws Exception {}
	
	@Test
	public void test() {
		Connection db = DBConnection.getInstance().getDBCon();
		assertNotNull(db);
	}
	
}
