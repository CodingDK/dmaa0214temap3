package ctrLayer;

import java.util.ArrayList;

import dbLayer.DBCustomer;
import dbLayer.IFDBCustomer;
import modelLayer.Customer;

public class CustomerCtr implements IFCustomerCtr {

	public CustomerCtr() {
		
	}

	@Override
	public ArrayList<Customer> searchCustomerByName(String customerName) {
		IFDBCustomer dbCus = new DBCustomer();
		return dbCus.findCustomerByName(customerName);
	}

	@Override
	public ArrayList<Customer> searchCustomerByPhone(String phone) {
		IFDBCustomer dbCus = new DBCustomer();
		return dbCus.findCustomerByPhone(phone);
	}

	@Override
	public Customer searchCustomerByID(int customerID) {
		IFDBCustomer dbCus = new DBCustomer();
		return dbCus.getCustomerByID(customerID);
	}

}
