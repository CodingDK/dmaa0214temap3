package testLayer;

import static org.junit.Assert.*;
import modelLayer.Product;

import org.junit.Test;

public class testProduct {

	@Test
	public void test() {
		
		// Testing that the ID started with 1 
		
		Product p1 = new Product("navn", 123);
		Product p2 = new Product("navn", 123);
		Product p3 = new Product("navn", 123);
		Product p4 = new Product("navn", 123);
		System.out.println(p1.getID());
		System.out.println(p2.getID());
		System.out.println(p3.getID());
		System.out.println(p4.getID());
		
	}

}
