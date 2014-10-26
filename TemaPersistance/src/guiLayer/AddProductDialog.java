package guiLayer;

import exceptions.NotEnoughStockException;
import exceptions.SubmitException;
import guiLayer.extensions.JDoubleField;
import guiLayer.extensions.JTextFieldLimit;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import modelLayer.PartOrder;
import modelLayer.Product;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import ctrLayer.IFOrderCtr;
import ctrLayer.OrderCtr;

public class AddProductDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtUnitPrice;
	private JTextField txtAmount;
	private Product prod;
	private OrderPanel target;
	private boolean done = false;
	private PartOrder existingPO;

	public AddProductDialog(Product prod, OrderPanel target) {
		super((JDialog) null, true);
		this.target = target;
		this.prod = prod;
		this.existingPO = target.getPartOrder(prod);
		setResizable(false);
		this.target = target;
		this.setSize(new Dimension(270, 170));
		this.setResizable(false);
				
		getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(5dlu;default)"),
						ColumnSpec.decode("max(44dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("left:default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("left:default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(5dlu;default)"), },
						new RowSpec[] { RowSpec.decode("5dlu"),
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
								FormFactory.DEFAULT_ROWSPEC, }));
		
		ActionListener escListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		};
		getRootPane().registerKeyboardAction(escListener,
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				JComponent.WHEN_IN_FOCUSED_WINDOW);

		JLabel lblTitle = new JLabel("#" + prod.getId() + " - "
				+ prod.getName());
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(lblTitle, "5, 3, center, default");

		JLabel lblAmount = new JLabel("Amount:");
		getContentPane().add(lblAmount, "3, 6, left, default");

		txtAmount = new JTextField(10);
		txtAmount.setDocument(new JTextFieldLimit(6, true, false));
		getContentPane().add(txtAmount, "5, 6, 3, 1, fill, default");

		JLabel lblUnitPrice = new JLabel("Unit price:");
		getContentPane().add(lblUnitPrice, "3, 8, left, default");

		txtUnitPrice = new JDoubleField(10);
		getContentPane().add(txtUnitPrice, "5, 8, 3, 1, fill, default");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addProduct();
			}
		});
		getContentPane().add(btnAdd, "5, 10");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		getContentPane().add(btnCancel, "7, 10, right, default");
		
		
		if (existingPO == null) {
			setTitle("Add Product");
			txtUnitPrice.setText(Double.toString(prod.getSalesPrice()));
			txtAmount.requestFocus();
		} else {
			setTitle("Edit PartOrder");
			txtAmount.setText(Integer.toString(existingPO.getAmount()));
			txtUnitPrice.setText(Double.toString(existingPO.getUnitPrice()));
			btnAdd.setText("Edit");
		}
		this.getRootPane().setDefaultButton(btnAdd);
	}

	private void addProduct() {
		try {
			IFOrderCtr oCtr = new OrderCtr(); 
			
			Product product = prod;
			if (txtUnitPrice.getText().isEmpty()) {
				throw new SubmitException("Unitprice can't be empty", txtUnitPrice);
			} else if (txtAmount.getText().isEmpty()) {
				throw new SubmitException("Amount can't be empty", txtAmount);
			}
				
			double unitPrice = Double.parseDouble(txtUnitPrice.getText());
			
			int amount = Integer.parseInt(txtAmount.getText());
			if(amount <= 0) {
				throw new SubmitException("Amount have to be greather than 0", txtAmount);
			}
			PartOrder po = null;
			if(existingPO == null) {
				po = oCtr.createPartOrder(product, amount, unitPrice);	
			} else {
				po = oCtr.editPartOrder(existingPO, amount, unitPrice);
			}
			target.addPartOrder(po);
			done = true;
			setVisible(false);
		
		} catch (SubmitException e) {
			e.showError();
		} catch (NotEnoughStockException e) {
			e.showDialog();
		}
	}

	public boolean isDone() {
		return done;
	}

}
