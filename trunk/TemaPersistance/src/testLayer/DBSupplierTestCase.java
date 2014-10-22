package testLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelLayer.Supplier;

import org.junit.Test;

import dbLayer.DBSupplier;

public class DBSupplierTestCase {

	@Test
	public void testFindSuppliersByName() {
		DBSupplier dbSup = new DBSupplier();
		ArrayList<Supplier> list = dbSup.findSuppliersByName("Lund");
		
		Supplier sp = null;
		int i = 0;
		boolean exist = false;
		while(i < list.size() && !exist){
			Supplier sup = list.get(i);
			if(sup.getName().equals("Lund")){
				sp = sup;
				exist = true;
			}
			i++;
		}
		
		assertNotNull(sp);
	}

	@Test
	public void testFindSuppliersByPhone() {
		DBSupplier dbSup = new DBSupplier();
		ArrayList<Supplier> list = dbSup.findSuppliersByPhone("88888888");
		
		Supplier sp = null;
		int i = 0;
		boolean exist = false;
		while(i < list.size() && !exist){
			Supplier sup = list.get(i);
			if(sup.getPhone().equals("88888888")){
				sp = sup;
				exist = true;
			}
			i++;
		}
		
		assertNotNull(sp);
	}

	@Test
	public void testFindSuppliersByID() {
		DBSupplier dbSup = new DBSupplier();
		Supplier sp = dbSup.findSuppliersByID(1);
		
		assertNotNull(sp);
	}

	@Test
	public void testInsertUpdateDeleteSupplier() {
		DBSupplier dbSup = new DBSupplier();
		Supplier sp = new Supplier();
		boolean test = false;
		
		int id = 0;

		{
			sp.setName("Nick");
			sp.setAddress("Noget");
			sp.setCountry("Denmark");
			sp.setPhone("00000000");
			sp.setEmail("Noget@noget.dk");
			sp.setZipcode(9440);
			
			int rc = -1;
			
			try {
				rc = dbSup.insertSupplier(sp);
				System.out.println(rc);
				id = sp.getId();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			if(rc == 1){
				test = true;
			}else{
				System.out.println("Insert failed");
				test = false;
			}
		}
		
		{
			sp.setName("Noget");
			
			int rc = -1;
			
			try {
				rc = dbSup.updateEmployee(sp);
				System.out.println(rc);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			if(rc == 1){
				test = true;
			}else{
				System.out.println("Update failed");
				test = false;
			}
		}
		
		{		
			int rc = -1;
			
			try {
				rc = dbSup.removeSupplier(sp);
				System.out.println(rc);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			if(rc == 1){
				test = true;
			}else{
				System.out.println("Remove failed");
				test = false;
			}
		}
		
		
		assertTrue(test);
	}
}
