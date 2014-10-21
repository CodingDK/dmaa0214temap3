package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MockUp1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MockUp1 frame = new MockUp1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MockUp1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Order", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 521, 263);
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 285, 163, 58);
		panel.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Subtotal: 100");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_5.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("VAT: 20");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_5.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Total: 120");
		lblNewLabel.setToolTipText("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel_5.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnSearchProduct = new JButton("Search Customer");
		btnSearchProduct.setBounds(541, 105, 116, 23);
		panel.add(btnSearchProduct);
		
		textField = new JTextField();
		textField.setBounds(645, 11, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("60211988");
		textField_1.setBounds(645, 42, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(645, 74, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setBounds(541, 14, 94, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone:");
		lblNewLabel_4.setBounds(541, 45, 94, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblSgehallj = new JLabel("eMail:");
		lblSgehallj.setBounds(541, 77, 94, 14);
		panel.add(lblSgehallj);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(541, 139, 331, 435);
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1, BorderLayout.CENTER);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Morten", "Peter", "Lasse", "Lau"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(1);
		scrollPane_1.setViewportView(list);
		
		JButton btnAddSelectedProduct = new JButton("Add Selected Customer");
		btnAddSelectedProduct.setBounds(667, 105, 145, 23);
		panel.add(btnAddSelectedProduct);
		
		JButton btnNewButton = new JButton("Add Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(426, 285, 105, 23);
		panel.add(btnNewButton);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(183, 285, 163, 58);
		panel.add(panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JLabel lblCustomer = new JLabel("Customer:");
		GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
		gbc_lblCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_lblCustomer.gridx = 0;
		gbc_lblCustomer.gridy = 0;
		panel_7.add(lblCustomer, gbc_lblCustomer);
		
		JLabel lblPeter = new JLabel("Peter");
		GridBagConstraints gbc_lblPeter = new GridBagConstraints();
		gbc_lblPeter.insets = new Insets(0, 0, 5, 0);
		gbc_lblPeter.gridx = 0;
		gbc_lblPeter.gridy = 1;
		panel_7.add(lblPeter, gbc_lblPeter);
		
		JLabel label_2 = new JLabel("60211988");
		label_2.setToolTipText("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel_7.add(label_2, gbc_label_2);
	}
}
