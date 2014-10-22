package guiLayer;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;

public class ProductPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtID;

	/**
	 * Create the panel.
	 */
	public ProductPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("150px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		add(panel_1, "1, 1, fill, fill");
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15px:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,}));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "2, 2, fill, fill");
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel_3 = new JLabel("Product");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_3.add(lblNewLabel_3, "1, 1, 3, 1, center, default");
		
		JLabel lblNewLabel = new JLabel("ProductID:");
		panel_3.add(lblNewLabel, "1, 3, left, default");
		
		txtID = new JTextField();
		panel_3.add(txtID, "3, 3, fill, default");
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Type:");
		panel_3.add(lblNewLabel_1, "1, 5, left, default");
		
		JComboBox cmbType = new JComboBox();
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"None", "Clothing", "Equipment", "Gunreplicas"}));
		panel_3.add(cmbType, "3, 5, fill, default");
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		panel_3.add(lblNewLabel_2, "1, 7, left, default");
		
		txtName = new JTextField();
		panel_3.add(txtName, "3, 7, fill, default");
		txtName.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "2, 4, fill, fill");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnSearchProduct = new JButton("Search Product");
		panel_2.add(btnSearchProduct, "1, 1, left, default");
		
		JButton btnAddSelected = new JButton("Add Selected");
		panel_2.add(btnAddSelected, "3, 1, right, default");
		
		JPanel panel = new JPanel();
		add(panel, "1, 3, fill, fill");
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Noget", "Noget Andet", "Noget HELT! Andet"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		scrollPane.setViewportView(list);

	}

}
