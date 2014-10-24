package guiLayer.extensions;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import modelLayer.Customer;

public class CustomerCellRender extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;
	private CustomerListPanel customerPanel;

	public CustomerCellRender() {

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list,
			Object value, int index, boolean isSelected, boolean cellHasFocus) {
		Customer c = (Customer) value;

		customerPanel = new CustomerListPanel(c.getName(), c.getAddress(), c
				.getZipcode().getZipcode(), c.getPhone(), c.getZipcode()
				.getCity(), !isSelected);

		return customerPanel;
	}

}
