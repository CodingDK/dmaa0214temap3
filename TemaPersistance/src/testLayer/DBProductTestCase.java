package testLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelLayer.Clothing;
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
		Product pr1 = dbProd.getProductByID(5);
		Product pr2 = dbProd.getProductByID(15);
		Product pr3 = dbProd.getProductByID(11);
		assertNotNull(pr1);
		assertNotNull(pr2);
		assertNotNull(pr3);
	}

	@Test
	public void testInsertUpdateDeleteProduct() throws Exception {
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
		
		//Insert Clothing
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
		
		//Insert GunReplica
		GunReplica pr4 = new GunReplica();
		pr4.setCountryOrigin("Testcountry");
		pr4.setMinStock(5);
		pr4.setName("Testname");
		pr4.setPurchasePrice(2.1);
		pr4.setRentPrice(22);
		pr4.setSalesPrice(2.11);
		pr4.setStock(222);		

		try {
			//Insert
			int insert = dbProd.insertProduct(pr);
			int insert2 = dbProd.insertProduct(pr2);
			int insert3 = dbProd.insertProduct(pr3);
			int insert4 = dbProd.insertProduct(pr4);
			assertTrue(insert == 1);
			assertTrue(insert2 == 2);
			assertTrue(insert3 == 2);
			assertTrue(insert4 == 2);
			System.out.println("Insert: " + insert);
			System.out.println("Insert2: " + insert2);
			System.out.println("Insert3: " + insert3);
			System.out.println("Insert4: " + insert4);
			
			//Update
			pr.setName("Nyt test navn 1");
			pr2.setName("Nyt test navn 2");
			pr2.setDescription("Ny description");
			pr3.setName("Nyt test navn 3");
			pr4.setName("Nyt test navn 4");
			int up = dbProd.updateProduct(pr);
			int up2 = dbProd.updateProduct(pr2);
			int up3 = dbProd.updateProduct(pr3);
			int up4 = dbProd.updateProduct(pr4);
			System.out.println("Up1: " + up);
			System.out.println("Up2: " + up2);
			System.out.println("Up3: " + up3);
			System.out.println("Up4: " + up4);
			assertTrue(up == 1);
			assertTrue(up2 == 1);
			assertTrue(up3 == 1);
			assertTrue(up4 == 1);
			
			//Delete
			int del1 = dbProd.removeProduct(pr);
			int del2 = dbProd.removeProduct(pr2);
			int del3 = dbProd.removeProduct(pr3);
			int del4 = dbProd.removeProduct(pr4);
			System.out.println("Del1: " + del1);
			System.out.println("Del2: " + del2);
			System.out.println("Del3: " + del3);
			System.out.println("Del4: " + del4);
			assertTrue(del1 == 1);
			assertTrue(del2 == 1);
			assertTrue(del3 == 1);
			assertTrue(del4 == 1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testGetProductsByType() {
		ArrayList<Product> list = dbProd.getProductsByType("EqUipmEnt");
		ArrayList<Product> list2 = dbProd.getProductsByType("CloThInG");
		ArrayList<Product> list3 = dbProd.getProductsByType("gUnRepliCa");
		ArrayList<Product> list4 = dbProd.getProductsByType("");
		assertNotNull(list);
		assertNotNull(list2);
		assertNotNull(list3);
		assertNotNull(list4);
		assertTrue(list.size() != 0);
		assertTrue(list2.size() != 0);
		assertTrue(list3.size() != 0);
		assertTrue(list4.size() != 0);
	}

}
