package guiLayer.extensions;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;

public class CustomerListPanel extends JPanel {
	private boolean isSelected;
	
	/**
	 * Create the panel.
	 */
	public CustomerListPanel(String name, String address, int zipcode, String phone, String city, boolean isSelected) {
		this.isSelected = isSelected;
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("max(29dlu;default):grow"),}));
		
		JPanel panel = new JPanel();
		add(panel, "1, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,}));
		
		JLabel lblNewLabel_2 = new JLabel(name);
		panel.add(lblNewLabel_2, "2, 2");
		
		JLabel lblNewLabel_1 = new JLabel("Phone: " + phone);
		panel.add(lblNewLabel_1, "4, 2");
		
		JLabel lblNewLabel_3 = new JLabel("Addr: " + address);
		panel.add(lblNewLabel_3, "2, 4");
		
		JLabel lblNewLabel = new JLabel("City: " + zipcode + " - " + city);
		panel.add(lblNewLabel, "4, 4");
		
	}
	
}
