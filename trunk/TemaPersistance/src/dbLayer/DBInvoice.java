package dbLayer;

import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Invoice;

public class DBInvoice implements IFDBInvoice {

	public DBInvoice() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Invoice> getAllInvoices(boolean retAsso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Invoice> getInvoicesByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return 0;
	}

}
