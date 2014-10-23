package guiLayer;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import modelLayer.Customer;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class ProductGUI extends JPanel {
	private JTable prodTable;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtCreateName;
	private JTextField txtCreateMinStock;
	private JTextField txtCreateStock;
	private JTextField txtPurchasePrice;
	private JTextField txtSalesPrice;
	private JTextField txtRentPrice;
	private JTextField txtClothingSize;
	private JTextField txtClothingColour;

	/**
	 * Create the panel.
	 */
	public ProductGUI() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("652px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("250px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("400px:grow"),
				FormFactory.LINE_GAP_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel, "2, 2, left, center");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "2, 4, fill, fill");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		prodTable = new JTable();
		prodTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(prodTable);
		
		JPanel panel = new JPanel();
		add(panel, "4, 4, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("max(63dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("135dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("47dlu:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(166dlu;default):grow"),}));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3, "1, 1, fill, fill");
		
		JPanel panel_4 = new JPanel();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
		);
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		panel_4.add(lblNewLabel_1, "1, 1, left, default");
		
		txtID = new JTextField();
		panel_4.add(txtID, "3, 1, fill, default");
		txtID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		panel_4.add(lblNewLabel_2, "1, 3, left, default");
		
		txtName = new JTextField();
		panel_4.add(txtName, "3, 3, fill, default");
		txtName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Type:");
		panel_4.add(lblNewLabel_3, "1, 5, left, default");
		
		JComboBox comboBox = new JComboBox();
		panel_4.add(comboBox, "3, 5, fill, default");
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, "1, 7, 3, 1, fill, fill");
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnNewButton_1 = new JButton("Clear");
		panel_5.add(btnNewButton_1, "1, 1, fill, default");
		
		JButton btnNewButton = new JButton("Search");
		panel_5.add(btnNewButton, "5, 1, fill, default");
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Create", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, "1, 3, fill, fill");
		
		JPanel panel_6 = new JPanel();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(237, Short.MAX_VALUE))
		);
		panel_6.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_4 = new JLabel("Name:");
		panel_6.add(lblNewLabel_4, "1, 1, left, default");
		
		txtCreateName = new JTextField();
		panel_6.add(txtCreateName, "3, 1, fill, default");
		txtCreateName.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Type:");
		panel_6.add(lblNewLabel_5, "1, 3, left, default");
		
		JComboBox cmbCreateType = new JComboBox();
		panel_6.add(cmbCreateType, "3, 3, fill, default");
		
		JLabel lblNewLabel_6 = new JLabel("Minimum Stock:");
		panel_6.add(lblNewLabel_6, "1, 5, left, default");
		
		txtCreateMinStock = new JTextField();
		panel_6.add(txtCreateMinStock, "3, 5, fill, default");
		txtCreateMinStock.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Stock:");
		panel_6.add(lblNewLabel_7, "1, 7, left, default");
		
		txtCreateStock = new JTextField();
		panel_6.add(txtCreateStock, "3, 7, fill, default");
		txtCreateStock.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Purchase Price:");
		panel_6.add(lblNewLabel_8, "1, 9, right, default");
		
		txtPurchasePrice = new JTextField();
		panel_6.add(txtPurchasePrice, "3, 9, fill, default");
		txtPurchasePrice.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Sales Price:");
		panel_6.add(lblNewLabel_9, "1, 11, left, default");
		
		txtSalesPrice = new JTextField();
		panel_6.add(txtSalesPrice, "3, 11, fill, default");
		txtSalesPrice.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Rent Price");
		panel_6.add(lblNewLabel_10, "1, 13, left, default");
		
		txtRentPrice = new JTextField();
		panel_6.add(txtRentPrice, "3, 13, fill, default");
		txtRentPrice.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Supplier:");
		panel_6.add(lblNewLabel_11, "1, 15, left, default");
		
		JComboBox cmbSupplier = new JComboBox();
		panel_6.add(cmbSupplier, "3, 15, fill, default");
		panel_2.setLayout(gl_panel_2);
		
		boolean something = true;
		
		if(false){
			JPanel panel_7 = new JPanel();
			panel_7.setBorder(new TitledBorder(null, "Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.add(panel_7, "1, 5, fill, fill");
			
			JPanel panel_8 = new JPanel();
			GroupLayout gl_panel_7 = new GroupLayout(panel_7);
			gl_panel_7.setHorizontalGroup(
				gl_panel_7.createParallelGroup(Alignment.LEADING)
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
			);
			gl_panel_7.setVerticalGroup(
				gl_panel_7.createParallelGroup(Alignment.LEADING)
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
			);
			panel_8.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("default:grow"),}));
			
			JLabel lblNewLabel_12 = new JLabel("Type:");
			panel_8.add(lblNewLabel_12, "1, 1, left, default");
			
			txtClothingSize = new JTextField();
			panel_8.add(txtClothingSize, "3, 1, fill, default");
			txtClothingSize.setColumns(10);
			
			JLabel lblNewLabel_13 = new JLabel("Description:");
			panel_8.add(lblNewLabel_13, "1, 3, 3, 1, center, default");
			
			JTextArea txtEquipmentDesc = new JTextArea();
			panel_8.add(txtEquipmentDesc, "1, 5, 3, 1, fill, fill");
			
			panel_7.setLayout(gl_panel_7);
		}else{
			JPanel panel_7 = new JPanel();
			panel_7.setBorder(new TitledBorder(null, "Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.add(panel_7, "1, 5, fill, fill");
			
			JPanel panel_8 = new JPanel();
			GroupLayout gl_panel_7 = new GroupLayout(panel_7);
			gl_panel_7.setHorizontalGroup(
				gl_panel_7.createParallelGroup(Alignment.LEADING)
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
			);
			gl_panel_7.setVerticalGroup(
				gl_panel_7.createParallelGroup(Alignment.LEADING)
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
			);
			panel_8.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			
			JLabel lblNewLabel_12 = new JLabel("Size:");
			panel_8.add(lblNewLabel_12, "1, 1, left, default");
			
			txtClothingSize = new JTextField();
			panel_8.add(txtClothingSize, "3, 1, fill, default");
			txtClothingSize.setColumns(10);
			
			JLabel lblNewLabel_14 = new JLabel("Colour:");
			panel_8.add(lblNewLabel_14, "1, 3, left, default");
			
			txtClothingColour = new JTextField();
			panel_8.add(txtClothingColour, "3, 3, fill, default");
			txtClothingColour.setColumns(10);
			
			panel_7.setLayout(gl_panel_7);
		}
	}
}
