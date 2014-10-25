package guiLayer.extensions;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class CustomerListPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel listPanel;

	/**
	 * Create the panel.
	 */
	public CustomerListPanel(String name, String address, int zipcode,
			String phone, String city, boolean isSelected) {
		setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("default:grow"), },
				new RowSpec[] { RowSpec.decode("max(29dlu;default):grow"), }));
		listPanel = new JPanel();

		if (!isSelected) {
			listPanel.setBorder(new MatteBorder(2, 2, 2, 2, new Color(
					100, 0, 0)));
		} else {
			listPanel.setBorder(new MatteBorder(0, 0, 1, 0, new Color(
					0, 0, 0)));
		}

		add(listPanel, "1, 1, fill, fill");
		listPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC, }, new RowSpec[] {
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC, }));

		JLabel lblNewLabel_2 = new JLabel(name);
		listPanel.add(lblNewLabel_2, "2, 2");

		JLabel lblNewLabel_1 = new JLabel("Phone: " + phone);
		listPanel.add(lblNewLabel_1, "4, 2");

		JLabel lblNewLabel_3 = new JLabel("Addr: " + address);
		listPanel.add(lblNewLabel_3, "2, 4");

		JLabel lblNewLabel = new JLabel("City: " + zipcode + " - " + city);
		listPanel.add(lblNewLabel, "4, 4");

	}

}
