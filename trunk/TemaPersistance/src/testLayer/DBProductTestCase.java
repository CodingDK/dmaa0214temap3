package testLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelLayer.Clothing;
import modelLayer.Customer;
import modelLayer.Equipment;
import modelLayer.GunReplica;
import modelLayer.Product;

import org.junit.Before;
import org.junit.Test;

import dbLayer.DBProduct;

public class DBProductTestCase {
	
	private DBProduct dbProd;

	@Before
	public void setUp() {
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
	public void testInsertUpdateDeleteProduct() throws Exception {
		//TODO
		// Insert product
		Product pr = new Product();
		pr.setCountryOrigin("Testcountry");
		pr.setMinStock(5);
		pr.setName("Testname");
		pr.setPurchasePrice(111.1);
		pr.setRentPrice(11111);
		pr.setSalesPrice(11.11);
		pr.setStock(111);
		
		// Insert Equipment
		Equipment pr2 = new Equipment();
		pr2.setCountryOrigin("Testcountry");
		pr2.setMinStock(5);
		pr2.setName("Testname");
		pr2.setPurchasePrice(2.1);
		pr2.setRentPrice(22);
		pr2.setSalesPrice(2.11);
		pr2.setStock(222);
		pr2.setDescription("Testdesc");
		pr2.setType("Testtype");
		
		Clothing pr3 = new Clothing();
		pr3.setCountryOrigin("Testcountry");
		pr3.setMinStock(5);
		pr3.setName("Testname");
		pr3.setPurchasePrice(2.1);
		pr3.setRentPrice(22);
		pr3.setSalesPrice(2.11);
		pr3.setStock(222);
		pr3.setSize("XL");
		pr3.setColour("Blue");
		
		GunReplica pr4 = new GunReplica();
		pr4.setCountryOrigin("Testcountry");
		pr4.setMinStock(5);
		pr4.setName("Testname");
		pr4.setPurchasePrice(2.1);
		pr4.setRentPrice(22);
		pr4.setSalesPrice(2.11);
		pr4.setStock(222);
		
		

		try {
			int insert = dbProd.insertProduct(pr);
			int insert2 = dbProd.insertProduct(pr2);
			int insert3 = dbProd.insertProduct(pr3);
			int insert4 = dbProd.insertProduct(pr4);
			assertTrue(insert == 1);
			assertTrue(insert2 == 2);
			assertTrue(insert3 == 3);
			assertTrue(insert4 == 4);
			System.out.println("Insert: " + insert);
			System.out.println("Insert2: " + insert2);
			System.out.println("Insert3: " + insert3);
			System.out.println("Insert4: " + insert4);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testGetProductsByType() {
		ArrayList<Product> list = dbProd.getProductsByType("EqUipmEnt");
		assertNotNull(list);
		assertTrue(list.size() != 0);
	}

}
