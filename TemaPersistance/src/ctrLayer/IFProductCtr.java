package ctrLayer;

import java.util.ArrayList;

import modelLayer.Product;

public interface IFProductCtr {

	public ArrayList<Product> getProductsByName(String productName);

	public ArrayList<Product> getProductsByType(String type);

	public Product getProductByID(int id);

}
