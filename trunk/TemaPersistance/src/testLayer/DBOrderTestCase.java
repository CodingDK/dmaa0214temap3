package testLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelLayer.Clothing;
import modelLayer.Customer;
import modelLayer.Invoice;
import modelLayer.Order;
import modelLayer.PartOrder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dbLayer.DBConnection;
import dbLayer.DBInvoice;
import dbLayer.DBOrder;
import dbLayer.DBPartOrder;
import dbLayer.DBProduct;
import dbLayer.IFDBInvoice;
import dbLayer.IFDBOrder;
import dbLayer.IFDBPartOrder;
import dbLayer.IFDBProduct;

public class DBOrderTestCase {


	@Test
	public void testGetAllOrders() {
		System.out.println("testGetAllOrders");
		IFDBOrder dbOrder = new DBOrder();
		ArrayList<Order> orders = dbOrder.getAllOrders();
		
		assertTrue(orders.size() > 0);
		
	}

	@Test
	public void testGetOrdersByInvoice() {
		System.out.println("testGetOrdersByInvoice");
		IFDBInvoice dbInv = new DBInvoice();
		
		Invoice i = dbInv.getInvoiceByID(1000);
		
		IFDBOrder dbOrder = new DBOrder();
		
		ArrayList<Order> orders = dbOrder.getOrdersByInvoice(i, false);
		
		assertTrue(orders.size() > 0);
	}

	@Test
	public void testGetOrdersByCustomer() {
		System.out.println("testGetOrdersByCustomer");
		IFDBOrder dbOrder = new DBOrder();
		
		Customer c = new Customer();
		c.setId(2);
		
		ArrayList<Order> orders = dbOrder.getOrdersByCustomer(c, false);
		
		assertTrue(orders.size() > 0);
	}

	@Test
	public void testGetOrderByID() {
		System.out.println("testGetOrderByID");
		IFDBOrder dbOrder = new DBOrder();

		Order o = dbOrder.getOrderByID(10004, false);
		
		assertTrue(o != null);
	}

	@Test
	public void testInsertOrder() {
		
		System.out.println("testInsertOrder");
		IFDBOrder dbOrder = new DBOrder();
		IFDBProduct dbProduct = new DBProduct();
		/*
		Order o = new Order();
		o.setDeliveryStatus("Teleported to Target!");
		
		Clothing c = (Clothing) dbProduct.getProductByID(4);
		
		PartOrder pO = new PartOrder();
		pO.setAmount(2);
		pO.setUnitPrice(50);
		pO.setProduct(c);
		pO.setParent(o);
		ArrayList<PartOrder> orders = new ArrayList<PartOrder>();
		orders.add(pO);
		o.setPs(orders);
		dbOrder.insertOrder(o);
	
		dbOrder.removeOrder(o);
		*/
		Order o = dbOrder.getOrderByID(10017, true);
		dbOrder.removeOrder(o);
	}

}
