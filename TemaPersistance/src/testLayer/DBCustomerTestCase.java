package testLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelLayer.Customer;

import org.junit.Before;
import org.junit.Test;

import dbLayer.DBCustomer;

public class DBCustomerTestCase {

	private DBCustomer dbCus;
	
	@Before
	public void setUp() throws Exception {
		dbCus = new DBCustomer();
	}

	@Test
	public void testGetAllCustomers() {
		ArrayList<Customer> list = dbCus.getAllCustomers();
		assertNotNull(list);
		assertTrue(list.size() != 0);
	}

	@Test
	public void testFindCustomerByName() {
		ArrayList<Customer> list = dbCus.findCustomerByName("e");
		assertNotNull(list);
		assertTrue(list.size() != 0);
	}

	@Test
	public void testFindCustomerByPhone() {
		ArrayList<Customer> list = dbCus.findCustomerByPhone("7");
		assertNotNull(list);
		assertTrue(list.size() != 0);
	}

	@Test
	public void testCreateUpdateDeleteCustomer() {
		Customer cus = new Customer();
		cus.setName("DB TEST");
		cus.setAddress("Testvejen 21");
		cus.setZipcode(9520);
		cus.setCity("Sk�rping");
		cus.setPhone("53453453");
		int insert = dbCus.insertCustomer(cus);
		assertTrue(insert == 1);
		System.out.println("insertTest: " + insert);
		System.out.println("cust id: " + cus.getId());
		cus.setName("DC Test");
		int update = dbCus.updateCustomer(cus);
		assertTrue(update == 1);
		System.out.println("updateTest: " + update);
		int delete = dbCus.deleteCustomer(cus);
		assertTrue(delete == 1);
		System.out.println("deleteTest: " + delete);
	}

}
