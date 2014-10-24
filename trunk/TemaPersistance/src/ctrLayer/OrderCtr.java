package ctrLayer;

import java.util.ArrayList;

import dbLayer.DBInvoice;
import dbLayer.DBOrder;
import dbLayer.DBProduct;
import dbLayer.IFDBInvoice;
import dbLayer.IFDBOrder;
import dbLayer.IFDBProduct;
import modelLayer.Customer;
import modelLayer.Invoice;
import modelLayer.Order;
import modelLayer.PartOrder;
import modelLayer.Product;

public class OrderCtr implements IFOrderCtr {
	
	public OrderCtr() {}
	
	@Override
	public void createOrder(ArrayList<PartOrder> poList, Customer cust, boolean invoice) {
		IFDBOrder dbOrder = new DBOrder();
		Order o = new Order();
		o.setPs(poList);
		o.setCustomer(cust);
		
		if(invoice){
			Invoice i = new Invoice();
			IFDBInvoice dbInv = new DBInvoice();
			dbInv.insertInvoice(i);
			o.setInvoice(i);
		}
		
		dbOrder.insertOrder(o);
	}
	
	@Override
	public ArrayList<Product> getProductsByName(String productName) {
		IFProductCtr prodCtr = new ProductCtr();
		return prodCtr.getProductsByName(productName);
	}
	
	@Override
	public ArrayList<Product> getProductsByType(String type) {
		IFProductCtr prodCtr = new ProductCtr();
		return prodCtr.getProductsByType(type);
	}
	
	@Override
	public Product getProductByID(int id) {
		IFProductCtr prodCtr = new ProductCtr();
		return prodCtr.getProductByID(id);
	}
	
	@Override
	public PartOrder createPartOrder(Product product, int amount, double unitPrice) throws Exception {
		PartOrder pO = new PartOrder();
		pO.setAmount(amount);
		pO.setProduct(product);
		pO.setUnitPrice(unitPrice);
		if(product.getStock() < amount){
			throw new Exception("Not enough items in stock!");
		}
		return pO;
	}
	
	@Override
	public ArrayList<Customer> searchCustomerByName(String customerName) {
		IFCustomerCtr cCtr = new CustomerCtr();
		return cCtr.searchCustomerByName(customerName);
	}
	
	@Override
	public ArrayList<Customer> searchCustomerByPhone(String phone) {
		IFCustomerCtr cCtr = new CustomerCtr();
		return cCtr.searchCustomerByPhone(phone);
	}
	
	@Override
	public Customer searchCustomerByID(int customerID) {
		IFCustomerCtr cCtr = new CustomerCtr();
		return cCtr.searchCustomerByID(customerID);
	}
	
}
