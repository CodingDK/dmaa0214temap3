package guiLayer;

import guiLayer.extensions.PartOrderTableModel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import modelLayer.Customer;
import modelLayer.PartOrder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.IFOrderCtr;
import ctrLayer.OrderCtr;

public class OrderPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel cardPanel;
	private boolean switchPanel = true;
	private JButton btnCustomerProduct;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblCityPostal;
	private JPanel customerInfoPanel;
	private Customer customer;
	private ArrayList<PartOrder> partOrders;
	private PartOrderTableModel model;
	private JCheckBox chckbxInvoice;
	private JLabel lblVat;
	private JLabel lblSubtotal;
	private JLabel lblTotal;
	private double totalPrice = 0;
	private double subTotal = 0;
	private double vat = 0;
	private Main parent;

	/**
	 * Create the panel.
	 */
	public OrderPanel(Main parent) {
		this.parent = parent;
		partOrders = new ArrayList<PartOrder>();

		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("652px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("266px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC, }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("400px:grow"),
				FormFactory.LINE_GAP_ROWSPEC, }));

		JLabel lblNewLabel = new JLabel("Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel, "2, 2, left, center");

		JPanel panel_1 = new JPanel();
		add(panel_1, "2, 4, fill, fill");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 113, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		model = new PartOrderTableModel(partOrders);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("170px"), FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("170px"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("75px"),
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("fill:24px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"), }));

		JPanel TotalPanel = new JPanel();
		TotalPanel.setBorder(new LineBorder(Color.GRAY));
		panel_4.add(TotalPanel, "1, 2, fill, fill");
		TotalPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(55dlu;default):grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC, }, new RowSpec[] {
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC, }));

		JLabel lblNewLabel_3 = new JLabel("Subtotal:");
		TotalPanel.add(lblNewLabel_3, "2, 2");

		lblSubtotal = new JLabel(subTotal + ",-");
		TotalPanel.add(lblSubtotal, "3, 2, right, default");

		JLabel lblNewLabel_2 = new JLabel("VAT:");
		TotalPanel.add(lblNewLabel_2, "2, 4");

		lblVat = new JLabel(vat + ",-");
		TotalPanel.add(lblVat, "3, 4, right, default");

		JLabel lblNewLabel_1 = new JLabel("Total:");
		TotalPanel.add(lblNewLabel_1, "2, 6");

		lblTotal = new JLabel(totalPrice + ",-");
		TotalPanel.add(lblTotal, "3, 6, right, default");

		customerInfoPanel = new JPanel();
		customerInfoPanel.setBorder(new LineBorder(Color.GRAY));
		panel_4.add(customerInfoPanel, "3, 2, fill, fill");
		customerInfoPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC, }, new RowSpec[] {
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, }));

		lblName = new JLabel("");
		customerInfoPanel.add(lblName, "1, 2, 4, 1, center, default");

		JLabel lblNewLabel_8 = new JLabel("Address:");
		customerInfoPanel.add(lblNewLabel_8, "2, 4");

		lblAddress = new JLabel("");
		customerInfoPanel.add(lblAddress, "4, 4, right, default");

		JLabel lblNewLabel_9 = new JLabel("City:");
		customerInfoPanel.add(lblNewLabel_9, "2, 6");

		lblCityPostal = new JLabel("");
		customerInfoPanel.add(lblCityPostal, "4, 6, right, default");

		customerInfoPanel.setVisible(false);

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, "1, 4, fill, fill");
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC, FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC, },
				new RowSpec[] { FormFactory.DEFAULT_ROWSPEC, }));

		JButton btnCommitSale = new JButton("Commit Sale");
		btnCommitSale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				commitSale();
			}
		});
		panel_5.add(btnCommitSale, "1, 1");

		chckbxInvoice = new JCheckBox("Invoice");
		panel_5.add(chckbxInvoice, "3, 1");

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(61dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("120px"), },
				new RowSpec[] { FormFactory.DEFAULT_ROWSPEC, }));

		btnCustomerProduct = new JButton("Add Customer");
		btnCustomerProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanel();
			}
		});
		panel_3.add(btnCustomerProduct, "4, 1");

		cardPanel = new JPanel();
		add(cardPanel, "4, 4, fill, fill");
		cardPanel.setLayout(new CardLayout(0, 0));

		ProductPanel pPanel = new ProductPanel(this);
		CustomerPanel cPanel = new CustomerPanel(this);

		cardPanel.add(pPanel, "Product");
		cardPanel.add(cPanel, "Customer");
	}

	protected void commitSale() {
		if (partOrders.size() > 0) {
			IFOrderCtr oCtr = new OrderCtr();
			int rc = oCtr.createOrder(partOrders, customer,
					chckbxInvoice.isSelected());
			System.out.println(rc);
			if (rc == 1) {
				JOptionPane.showMessageDialog(null, "The order was created!",
						"InfoBox", JOptionPane.INFORMATION_MESSAGE);
				parent.replaceOrderPanel();
			} else {
				JOptionPane.showMessageDialog(null,
						"The order creation Failed!", "InfoBox",
						JOptionPane.WARNING_MESSAGE);
			}

		}
	}

	public void switchPanel() {
		CardLayout cl = (CardLayout) (cardPanel.getLayout());
		if (switchPanel) {
			btnCustomerProduct.setText("Add Product");
			cl.show(cardPanel, "Customer");
			switchPanel = false;
		} else {
			if (customer != null) {
				btnCustomerProduct.setText("Change Customer");
			} else {
				btnCustomerProduct.setText("Add Customer");
			}
			cl.show(cardPanel, "Product");
			switchPanel = true;
		}
	}

	public void setCustomer(Customer c) {
		if (c != null) {
			customer = c;
			lblAddress.setText(c.getAddress());
			lblCityPostal.setText(c.getZipcode().getZipcode() + " - "
					+ c.getZipcode().getCity());
			lblName.setText(c.getName());

			customerInfoPanel.setVisible(true);
		}
	}

	public void addPartOrder(PartOrder pO) {
		if (pO != null) {
			if(!partOrders.contains(pO)) {
				partOrders.add(pO);
			}
			
			updateTable();

			subTotal = 0;

			for (PartOrder p : partOrders) {
				subTotal += (p.getAmount() * p.getUnitPrice());
			}

			vat = subTotal * 0.25;
			totalPrice = subTotal + vat;

			lblVat.setText(vat + ",-");
			lblTotal.setText(totalPrice + ",-");
			lblSubtotal.setText(subTotal + ",-");
		}

	}

	private void updateTable() {
		model.refresh(partOrders);
		model.fireTableDataChanged();
	}
	
	protected ArrayList<PartOrder> getPartOrders() {
		return partOrders;
	}
	
	public JFrame getParentFrame() {
		return parent;
	}
		

}
