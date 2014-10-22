package dbLayer;

import java.util.ArrayList;

import modelLayer.Product;

public class DBProduct implements IFDBProduct {
	
	public DBProduct() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Product> searchProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Product getProductByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int insertProduct(Product prod) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updateProduct(Product prod) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int removeProduct(Product prod) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
