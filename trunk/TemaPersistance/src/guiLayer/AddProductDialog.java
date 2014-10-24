package guiLayer;

import javax.swing.JDialog;

import modelLayer.PartOrder;
import modelLayer.Product;

import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import ctrLayer.IFOrderCtr;
import ctrLayer.OrderCtr;
import ctrLayer.exceptions.NotEnoughStockException;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProductDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtAmount;
	private JTextField txtUnitPrice;
	private Product prod;
	private OrderPanel target;
	private boolean done = false;

	public AddProductDialog(Product prod, OrderPanel target) {
		super((JDialog)null, true);
		setResizable(false);
		this.prod = prod;
		this.target = target;
		this.setSize(new Dimension(270, 170));
		this.setResizable(false);
		
		setTitle("Add Product");
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(5dlu;default)"),
				ColumnSpec.decode("max(44dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(5dlu;default)"),},
				new RowSpec[] {
				RowSpec.decode("5dlu"),
				RowSpec.decode("max(5dlu;default)"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("max(5dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("13dlu"),
				FormFactory.DEFAULT_ROWSPEC,}));

		JLabel lblTitle = new JLabel("#" + prod.getId() + " - " + prod.getName());
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblTitle, "5, 3, center, default");

		JLabel lblPrice = new JLabel("Unit price:");
		getContentPane().add(lblPrice, "3, 6, left, default");

		txtUnitPrice = new JTextField("" + prod.getSalesPrice());
		getContentPane().add(txtUnitPrice, "5, 6, 3, 1, fill, default");
		txtUnitPrice.setColumns(10);

		JLabel lblAmount = new JLabel("Amount:");
		getContentPane().add(lblAmount, "3, 8, left, default");

		txtAmount = new JTextField();
		getContentPane().add(txtAmount, "5, 8, 3, 1, fill, default");
		txtAmount.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addProduct();
			}
		});
//		JRootPane rootPane = SwingUtilities.getRootPane(btnAdd); 
//		rootPane.setDefaultButton(btnAdd);
		getContentPane().add(btnAdd, "5, 10");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}
		});
		getContentPane().add(btnCancel, "7, 10, right, default");
	}
	private void addProduct() {
		try{
			OrderCtr oCtr = new OrderCtr(); //TODO IFOrderCtr -- Giver syntax: Unhandled error 
			Product product = prod;
			int amount = Integer.parseInt(txtAmount.getText());
			Double unitPrice = Double.parseDouble(txtUnitPrice.getText());
			try{
			oCtr.createPartOrder(product, amount, unitPrice);
			PartOrder po = oCtr.createPartOrder(product, amount, unitPrice);
			target.addProductToOrder(po);
			done = true;
			setVisible(false);
			}
			catch(NotEnoughStockException e){
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			done = true;
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Amount must be a whole number", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void exit(){
		setVisible(false);
	}
	
	public boolean isDone(){
		return done;
	}

	

}
