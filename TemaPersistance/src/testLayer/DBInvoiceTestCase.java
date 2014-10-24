package testLayer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import modelLayer.Customer;
import modelLayer.Invoice;

import org.junit.Before;
import org.junit.Test;

import dbLayer.DBInvoice;

public class DBInvoiceTestCase {

	private DBInvoice dbInvoice;

	@Before
	public void setUp() throws Exception {
		dbInvoice = new DBInvoice();
	}

	@Test
	public void testGetAllInvoices() {
		ArrayList<Invoice> list = dbInvoice.getAllInvoices();
		assertNotNull(list);
		assertTrue(list.size() != 0);
	}

	@Test
	public void testGetInvoicesByCustomer() {
		Customer cus = new Customer(2);
		ArrayList<Invoice> list = dbInvoice.getInvoicesByCustomer(cus);
		assertNotNull(list);
		assertTrue(list.size() != 0);
	}

	@Test
	public void testInsertUpdateDeleteInvoice() {
		Invoice inv = new Invoice();
		int insert = dbInvoice.insertInvoice(inv);
		assertTrue(insert == 1);
		System.out.println("insertTest: " + insert);
		System.out.println("Invoice id: " + inv.getInvoiceID());
		inv.setDate(new Date(1413195001));
		int update = dbInvoice.updateInvoice(inv);
		assertTrue(update == 1);
		System.out.println("updateTest: " + update);
		int delete = dbInvoice.removeInvoice(inv);
		assertTrue(delete == 1);
		System.out.println("deleteTest: " + delete);

	}

}
