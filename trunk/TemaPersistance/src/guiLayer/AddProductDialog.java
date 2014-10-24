package guiLayer;

import javax.swing.JDialog;

import modelLayer.PartOrder;
import modelLayer.Product;

import javax.swing.JTextField;

import java.awt.BorderLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import ctrLayer.OrderCtr;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProductDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtAmount;
	private JTextField txtPrice;
	private Product prod;
	public AddProductDialog(Product prod, OrderPanel target) {
		this.prod = prod;
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
		
		JLabel lblPrice = new JLabel("Price:");
		getContentPane().add(lblPrice, "3, 6, left, default");
		
		txtPrice = new JTextField();
		getContentPane().add(txtPrice, "5, 6, 3, 1, fill, default");
		txtPrice.setColumns(10);
		
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
		getContentPane().add(btnAdd, "5, 10");
		
		JButton btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel, "7, 10, right, default");
	}
	private void addProduct() {
		// TODO Auto-generated method stub
		OrderCtr oCtr = new OrderCtr();
		Product product = prod;
		try{
		int amount = Integer.parseInt(txtAmount.getText());
		//PartOrder po = oCtr.createPartOrder(product, amount, unitPrice);
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Amount must be a whole number", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		  
		//parent.addProductToOrder(po);
	}
	
	public Boolean isDone(){
		boolean done = false;
		
		return done;
	}

}
