package ctrLayer;

import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;
import modelLayer.Order;
import modelLayer.PartOrder;
import modelLayer.Product;
import dbLayer.DBInvoice;
import dbLayer.DBOrder;
import dbLayer.IFDBInvoice;
import dbLayer.IFDBOrder;
import exceptions.NotEnoughStockException;

public class OrderCtr implements IFOrderCtr {

	public OrderCtr() {
	}

	@Override
	public int createOrder(ArrayList<PartOrder> poList, Customer cust,
			boolean invoice) {
		IFDBOrder dbOrder = new DBOrder();
		Order o = new Order();
		o.setPs(poList);
		o.setCustomer(cust);
		o.setDeliveryStatus("Order Created");
		if (invoice) {
			Invoice i = new Invoice();
			IFDBInvoice dbInv = new DBInvoice();
			dbInv.insertInvoice(i);
			o.setInvoice(i);
		}

		return dbOrder.insertOrder(o);
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
	public PartOrder createPartOrder(Product product, int amount,
			double unitPrice) throws NotEnoughStockException {
		if (product.getStock() < amount) {
			throw new NotEnoughStockException("Not enough items in stock!");
		}
		PartOrder pO = new PartOrder();
		pO.setAmount(amount);
		pO.setProduct(product);
		pO.setUnitPrice(unitPrice);
		return pO;
	}

	@Override
	public PartOrder editPartOrder(PartOrder partOrder, int newAmount,
			double newUnitPrice) throws NotEnoughStockException {
		if (partOrder.getProduct().getStock() < newAmount) {
			throw new NotEnoughStockException("Not enough items in stock!");
		}
		partOrder.setAmount(newAmount);
		partOrder.setUnitPrice(newUnitPrice);
		return partOrder;
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
