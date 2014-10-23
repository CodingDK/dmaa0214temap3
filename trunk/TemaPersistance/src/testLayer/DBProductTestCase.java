package testLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Product;

import org.junit.Before;
import org.junit.Test;

import dbLayer.DBProduct;

public class DBProductTestCase {
	
	private DBProduct dbProd;

	@Before
	public void setUp() throws Exception {
		dbProd = new DBProduct();
	}

	@Test
	public void testGetAllProducts() {
		ArrayList<Product> list = dbProd.getAllProducts();
		assertNotNull(list);
		assertTrue(list.size() != 0);	
	}

	@Test
	public void testSearchProduct() {
		ArrayList<Product> list = dbProd.searchProduct("e");
		assertNotNull(list);
		assertTrue(list.size() != 0);
	}

	@Test
	public void testGetProductByID() {
		Product product = dbProd.getProductByID(5);
		assertNotNull(product);
	}

	@Test
	public void testInsertUpdateDeleteProduct() {
		//TODO
		Product pr = new Product();
		pr.setCountryOrigin("Denmark");
		pr.setMinStock(5);
		pr.setName("Hejsa");
		pr.setPurchasePrice(350.5);
		pr.setRentPrice(7213.5);
		pr.setSalesPrice(1237.7);
		pr.setStock(9);
		int insert = dbProd.insertProduct(pr);		
	}

	@Test
	public void testGetProductsByType() {
		ArrayList<Product> list = dbProd.getProductsByType("EqUipmEnt");
		assertNotNull(list);
		assertTrue(list.size() != 0);
	}

}
