package guiLayer;

import guiLayer.extensions.CustomerCellRender;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import ctrLayer.CustomerCtr;
import ctrLayer.IFCustomerCtr;

import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;

import modelLayer.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerPanel extends JPanel {
	private JTextField txtPhone;
	private JTextField txtID;
	private JTextField txtName;
	private IFCustomerCtr cCtr;
	private JList list;

	/**
	 * Create the panel.
	 */
	public CustomerPanel() {
		cCtr = new CustomerCtr();
		buildPanel();
	}

	private void buildPanel() {
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
		
		JLabel lblNewLabel_3 = new JLabel("Customer");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_3.add(lblNewLabel_3, "1, 1, 3, 1, center, default");
		
		JLabel lblNewLabel = new JLabel("CustomerID");
		panel_3.add(lblNewLabel, "1, 3, left, default");
		
		txtID = new JTextField();
		panel_3.add(txtID, "3, 3, fill, default");
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		panel_3.add(lblNewLabel_1, "1, 5, left, default");
		
		txtName = new JTextField();
		panel_3.add(txtName, "3, 5, fill, default");
		txtName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone:");
		panel_3.add(lblNewLabel_2, "1, 7, left, default");
		
		txtPhone = new JTextField();
		panel_3.add(txtPhone, "3, 7, fill, default");
		txtPhone.setColumns(10);
		
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
		
		JButton btnSearchCustomer = new JButton("Search Customer");
		btnSearchCustomer.addActionListener(new ActionListener() {
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
		
		list = new JList();
		CustomerCellRender cRender = new CustomerCellRender();
		list.setCellRenderer(cRender);
		list.setSelectedIndex(0);
		scrollPane.setViewportView(list);

	}
	
	private void searchCustomer(){

		if(!txtID.getText().isEmpty()){
			ArrayList<Customer> customers = new ArrayList<Customer>();
			Customer c = cCtr.searchCustomerByID(Integer.parseInt(txtID.getText()));
			if(c != null){
				customers.add(c);
			}

			redraw(customers);
	
		}
		
		
		
		ArrayList<Customer> customers = cCtr.searchCustomerByName("");
	}
	
	
	protected void redraw(final ArrayList<Customer> customers) {
		Thread t = new Thread(){
			public void run(){
				DefaultListModel<Customer> model = new DefaultListModel<Customer>();
				if(customers.size() > 0){
					for(Customer c : customers){
						model.addElement(c);
					}
				}
				list.setModel(model);
			}
		};
		
		t.start();
	}

}
