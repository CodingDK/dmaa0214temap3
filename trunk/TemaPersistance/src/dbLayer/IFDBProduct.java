package dbLayer;

import java.util.ArrayList;

import modelLayer.Product;

public interface IFDBProduct {
	
	// Get all Products
	public ArrayList<Product> getAllProducts();
	
	// Search Products by name
	public ArrayList<Product> searchProduct(String name);
	
	//Get product by ID
	public Product getProductByID(int id);
	
	//Get product by type
	public ArrayList<Product> getProductsByType(String type);
	
	// Insert a Product
	public int insertProduct(Product prod) throws Exception;
	
	// Update a product
	public int updateProduct(Product prod);
	
	// Remove Product
	public int removeProduct(Product prod);
}
