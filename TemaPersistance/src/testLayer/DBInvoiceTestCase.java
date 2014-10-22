package testLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import modelLayer.Order;

import org.junit.Before;
import org.junit.Test;

public class DBInvoiceTestCase {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDBInvoice() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllInvoices() {
		ArrayList<Order> orders = new ArrayList<Order>();

		for (int j = 0; j < 10; j++) {
			orders.add(new Order(j));
		} 
		
		System.out.println(orders);
		HashSet<Integer> orderIDs = new HashSet<Integer>();
		orders.forEach((i) -> orderIDs.add(i.getOrderID()));
		String strIDs = "";
		for(Integer i : orderIDs) {
			if(!strIDs.isEmpty()) {
				strIDs += ",";
			}
			strIDs += i;
		}
		System.out.println(strIDs);
	}

	@Test
	public void testGetInvoicesByCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertInvoice() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateInvoice() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveInvoice() {
		fail("Not yet implemented");
	}

}
