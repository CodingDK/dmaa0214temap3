package ctrLayer;

import java.util.ArrayList;

import modelLayer.Product;
import dbLayer.DBProduct;
import dbLayer.IFDBProduct;

public class ProductCtr implements IFProductCtr {

	public ProductCtr() {

	}

	@Override
	public ArrayList<Product> getProductsByName(String productName) {
		IFDBProduct dbProd = new DBProduct();
		return dbProd.searchProduct(productName);
	}

	@Override
	public ArrayList<Product> getProductsByType(String type) {
		IFDBProduct dbProd = new DBProduct();
		return dbProd.getProductsByType(type);
	}

	@Override
	public Product getProductByID(int id) {
		IFDBProduct dbProd = new DBProduct();
		return dbProd.getProductByID(id);
	}

}
