package guiLayer;

import guiLayer.extensions.ProductCellRender;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import ctrLayer.IFOrderCtr;
import ctrLayer.OrderCtr;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.JButton;

import modelLayer.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ProductPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtID;
	private OrderPanel parent;
	private IFOrderCtr oCtr;
	private JList<Product> list;
	private JComboBox<String> cmbType;
	private ArrayList<Component> fields;

	/**
	 * Create the panel.
	 */
	public ProductPanel(OrderPanel parent) {
		this.parent = parent;
		oCtr = new OrderCtr();
		
		fields = new ArrayList<Component>();
		
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
		fields.add(txtID);
		JLabel lblNewLabel_1 = new JLabel("Type:");
		panel_3.add(lblNewLabel_1, "1, 5, left, default");
		
		cmbType = new JComboBox<String>();
		cmbType.setModel(new DefaultComboBoxModel<String>(new String[] {"Select", "All", "N/A", "Clothing", "Equipment", "GunReplica"}));
		panel_3.add(cmbType, "3, 5, fill, default");
		fields.add(cmbType);
		JLabel lblNewLabel_2 = new JLabel("Name:");
		panel_3.add(lblNewLabel_2, "1, 7, left, default");
		
		txtName = new JTextField();
		panel_3.add(txtName, "3, 7, fill, default");
		txtName.setColumns(10);
		fields.add(txtName);
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "2, 4, fill, fill");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnAddSelected = new JButton("Add Selected");
		panel_2.add(btnAddSelected, "1, 1, left, default");
		
		JButton btnSearchProduct = new JButton("Search Product");
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchProduct();
			}
		});
		panel_2.add(btnSearchProduct, "3, 1, right, default");
		
		JPanel panel = new JPanel();
		add(panel, "1, 3, fill, fill");
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList<Product>();
		ProductCellRender render = new ProductCellRender();
		list.setCellRenderer(render);
		list.setSelectedIndex(0);
		scrollPane.setViewportView(list);
		
		addOnChangeListener();
	}

	private void searchProduct() {
		String typeStr = (String) cmbType.getSelectedItem();
		System.out.println(typeStr);
		if(!typeStr.equalsIgnoreCase("Select")) {
			if(typeStr.equalsIgnoreCase("All")) {
				typeStr = "";
			}
			ArrayList<Product> pList = oCtr.getProductsByType(typeStr);
			updateList(pList);
		}
		if(!txtID.getText().isEmpty()) {
			Product p = oCtr.getProductByID(Integer.parseInt(txtID.getText()));
			ArrayList<Product> pList = new ArrayList<Product>();
			if(p != null) {
				pList.add(p);
			}
			updateList(pList);
		}
		else if (!txtName.getText().isEmpty()) {
			ArrayList<Product> pList = oCtr.getProductsByName(txtName.getText());
			updateList(pList);
		}
		clear();
	}
	
	private void clear() {
		txtID.setText("");
		txtName.setText("");
		cmbType.setSelectedIndex(0);
	}

	private void updateList(ArrayList<Product> products) {
		DefaultListModel<Product> model = new DefaultListModel<Product>();
		for (Product p : products) {
			model.addElement(p);
		}
		list.setModel(model);
	}

	private void addOnChangeListener() {
		for (final Component c : fields) {
			if(c instanceof JTextField) {
			((JTextField)c).getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void changedUpdate(DocumentEvent arg0) {
					updateFields(c);
				}
				@Override
				public void insertUpdate(DocumentEvent arg0) {
					updateFields(c);
				}
				@Override
				public void removeUpdate(DocumentEvent arg0) {
					updateFields(c);
				}

				});
			} 
			else if(c instanceof JComboBox) {
				((JComboBox<?>) c).addActionListener (new ActionListener () {
				    public void actionPerformed(ActionEvent e) {
				        updateFields(c);
				    }
				});
			}
				
		}
		
	}

	private void updateFields(Component c) {
		boolean empty = true;
		if(c instanceof JTextField) {
			empty = ((JTextField) c).getText().isEmpty();
		}
		if(c instanceof JComboBox) {
			empty = (((JComboBox<?>) c).getSelectedIndex() == 0);
		}
		if(!empty) {
			for (Component component : fields) {
				component.setEnabled(false);
			}
			c.setEnabled(true);
		} else {
			for (Component component : fields) {
				component.setEnabled(true);
			}
		}
	}
}
