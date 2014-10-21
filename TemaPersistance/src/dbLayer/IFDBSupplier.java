package dbLayer;

import java.util.ArrayList;

import modelLayer.Supplier;

public interface IFDBSupplier {
	
	// Get all Suppliers
	public ArrayList<Supplier> getAllSuppliers();
	
	// Get Suppliers by name
	public ArrayList<Supplier> findSuppliersByName(String name);
	
	// Get Suppliers by phone
	public ArrayList<Supplier> findSuppliersByPhone(String phone);
	
	// Get Supplier by id
	public Supplier findSuppliersByID(int id);
	
	// Insert a new Supplier
	public int insertSupplier(Supplier sp) throws Exception;
	
	// updates a Employee
	public int updateEmployee(Supplier sp);
	
	// Remove Supplier
	public int removeSupplier(Supplier sp);
	
}
