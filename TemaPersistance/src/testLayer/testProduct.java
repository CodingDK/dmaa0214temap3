package testLayer;

import org.junit.Test;

import modelLayer.Product;

public class testProduct {

	@Test
	public void test() {
		
		// Testing that the ID started with 1 
		
		Product p1 = new Product("navn", 123);
		Product p2 = new Product("navn", 123);
		Product p3 = new Product("navn", 123);
		Product p4 = new Product("navn", 123);
		System.out.println(p1.getId());
		System.out.println(p2.getId());
		System.out.println(p3.getId());
		System.out.println(p4.getId());
		
	}

}
