package guiLayer.extensions;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import modelLayer.Product;

public class ProductCellRender extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;
	private ProductListPanel productPanel;

	public ProductCellRender() {

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list,
			Object value, int index, boolean isSelected, boolean cellHasFocus) {
		Product product = (Product) value;
		productPanel = new ProductListPanel(product, !isSelected);

		return productPanel;
	}

}
