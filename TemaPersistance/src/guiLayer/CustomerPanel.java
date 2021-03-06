package guiLayer;

import guiLayer.extensions.CustomerCellRender;
import guiLayer.extensions.JTextFieldLimit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelLayer.Customer;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.IFOrderCtr;
import ctrLayer.OrderCtr;

public class CustomerPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtPhone;
	private JTextField txtID;
	private JTextField txtName;
	private IFOrderCtr oCtr;
	private JList<Customer> list;
	private OrderPanel parent;
	private ArrayList<Component> fields;
	private JButton btnAddSelected;
	private JButton btnSearchCustomer;

	/**
	 * Create the panel.
	 */
	protected CustomerPanel(OrderPanel parent) {
		fields = new ArrayList<Component>();
		this.parent = parent;
		oCtr = new OrderCtr();
		buildPanel();
	}

	private void buildPanel() {
		setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("default:grow"), },
				new RowSpec[] { RowSpec.decode("150px"),
						FormFactory.LINE_GAP_ROWSPEC,
						RowSpec.decode("default:grow"), }));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		add(panel_1, "1, 1, fill, fill");
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC, }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("15px:grow"),
				FormFactory.RELATED_GAP_ROWSPEC, }));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "2, 2, fill, fill");
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"), }));

		JLabel lblNewLabel_3 = new JLabel("Customer");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_3.add(lblNewLabel_3, "1, 1, 3, 1, center, default");

		JLabel lblNewLabel = new JLabel("CustomerID");
		panel_3.add(lblNewLabel, "1, 3, left, default");

		txtID = new JTextField();
		txtID.setDocument(new JTextFieldLimit(10, true, false));
		panel_3.add(txtID, "3, 3, fill, default");
		txtID.setColumns(10);
		fields.add(txtID);

		JLabel lblNewLabel_1 = new JLabel("Name:");
		panel_3.add(lblNewLabel_1, "1, 5, left, default");

		txtName = new JTextField();
		panel_3.add(txtName, "3, 5, fill, default");
		txtName.setColumns(10);
		fields.add(txtName);

		JLabel lblNewLabel_2 = new JLabel("Phone:");
		panel_3.add(lblNewLabel_2, "1, 7, left, default");

		txtPhone = new JTextField();
		panel_3.add(txtPhone, "3, 7, fill, default");
		txtPhone.setColumns(10);
		fields.add(txtPhone);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "2, 4, fill, fill");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC, },
				new RowSpec[] { FormFactory.DEFAULT_ROWSPEC, }));

		btnAddSelected = new JButton("Add Selected");
		btnAddSelected.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedCustomer();
			}
		});
		panel_2.add(btnAddSelected, "1, 1, left, default");

		btnSearchCustomer = new JButton("Search Customer");
		btnSearchCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchCustomer();
			}
		});
		panel_2.add(btnSearchCustomer, "3, 1, right, default");

		JPanel panel = new JPanel();
		add(panel, "1, 3, fill, fill");
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		list = new JList<Customer>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				selectionListener();;
			}
		});
		CustomerCellRender cRender = new CustomerCellRender();
		list.setCellRenderer(cRender);
		list.setSelectedIndex(0);
		scrollPane.setViewportView(list);

		parent.setDefaultButton(btnSearchCustomer);
		
		addOnChangeListener();
	}

	private void selectionListener() {
		btnAddSelected.setEnabled(!list.isSelectionEmpty());
		if (!list.isSelectionEmpty()) {
			parent.setDefaultButton(btnAddSelected);
		}
	}

	protected void selectedCustomer() {
		if (list.getSelectedValue() != null) {
			Customer c = list.getSelectedValue();
			parent.setCustomer(c);
			parent.switchPanel();
		}
	}

	private void searchCustomer() {
		if (!txtID.getText().isEmpty()) {
			ArrayList<Customer> customers = new ArrayList<Customer>();
			Customer c = oCtr.searchCustomerByID(Integer.parseInt(txtID
					.getText()));
			if (c != null) {
				customers.add(c);
			}
			redraw(customers);
		} else if (!txtName.getText().isEmpty()) {
			ArrayList<Customer> customers = oCtr.searchCustomerByName(txtName
					.getText());
			redraw(customers);
		} else if (!txtPhone.getText().isEmpty()) {
			ArrayList<Customer> customers = oCtr.searchCustomerByPhone(txtPhone
					.getText());
			redraw(customers);
		}
		clear();
	}

	private void clear() {
		txtID.setText("");
		txtName.setText("");
		txtPhone.setText("");
	}

	protected void redraw(final ArrayList<Customer> customers) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				DefaultListModel<Customer> model = new DefaultListModel<Customer>();
				if (customers.size() > 0) {
					for (Customer c : customers) {
						model.addElement(c);
					}
				}
				list.setModel(model);
			}
		});
	}

	private void addOnChangeListener() {
		for (final Component c : fields) {
			if (c instanceof JTextField) {
				((JTextField) c).getDocument().addDocumentListener(
						new DocumentListener() {
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
			} else if (c instanceof JComboBox) {
				((JComboBox<?>) c).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						updateFields(c);
					}
				});
			}
		}
	}

	private void updateFields(Component c) {
		boolean empty = true;
		if (c instanceof JTextField) {
			empty = ((JTextField) c).getText().isEmpty();
		}
		if (!empty) {
			ArrayList<Component> comps = new ArrayList<Component>(fields);
			comps.remove(c);
			for (Component component : comps) {
				component.setEnabled(false);
			}
			parent.setDefaultButton(btnSearchCustomer);
		} else {
			for (Component component : fields) {
				component.setEnabled(true);
			}
		}
	}
	
	protected JButton getDefaultButton() {
		return btnSearchCustomer;
	}
}
