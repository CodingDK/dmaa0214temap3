package guiLayer.extensions;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;

import modelLayer.Product;

public class ProductListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ProductListPanel(Product product, boolean isSelected) {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblidNavn = new JLabel("#ID - Navn");
		add(lblidNavn, "1, 2, 4, 1, center, default");
		
		JPanel panel = new JPanel();
		add(panel, "1, 4, 4, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_1 = new JLabel("Type:");
		panel.add(lblNewLabel_1, "2, 1");
		
		JLabel lblNewLabel = new JLabel("Antal:");
		panel.add(lblNewLabel, "4, 1");
		
		JLabel lblSubclass_1 = new JLabel("subclass");
		panel.add(lblSubclass_1, "2, 3");
		
		JLabel lblSubclass = new JLabel("subclass2");
		panel.add(lblSubclass, "4, 3");
		
		JLabel lblPurprice = new JLabel("PurPrice:");
		panel.add(lblPurprice, "2, 5");
		
		JLabel lblPrice = new JLabel("SalePrice:");
		panel.add(lblPrice, "4, 5");
	}

}
