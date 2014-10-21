package dbLayer;

import java.util.ArrayList;

import modelLayer.Supplier;

public interface IFDBSupplier {
	
	// Get all Suppliers
	public ArrayList<Supplier> getAllSuppliers();
	
	// Get Supplier by name
	public Supplier findSupplierByName(String name);
	
	// Insert a new Supplier
	public int insertSupplier(Supplier sp) throws Exception;
	
	// updates a Employee
	public int updateEmployee(Supplier sp);
	
	// Remove Supplier
	public int removeSupplier(Supplier sp);
	
}
