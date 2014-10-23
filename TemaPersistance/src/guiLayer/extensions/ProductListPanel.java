package guiLayer.extensions;

import java.awt.Color;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import modelLayer.Clothing;
import modelLayer.Equipment;
import modelLayer.GunReplica;
import modelLayer.Product;

public class ProductListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ProductListPanel(Product product, boolean isSelected) {
		
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblIdName = new JLabel("#" + product.getId() + " - " + product.getName());
		add(lblIdName, "1, 2, 4, 1, center, default");
		
		JPanel panel = new JPanel();
		
		if(!isSelected){
			setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(100, 0, 0)));
		}else{
			setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
		
		add(panel, "1, 4, 4, 1, fill, fill");
		
		JLabel lblPurprice = new JLabel("PurPrice: " + product.getPurchasePrice());
		
		JLabel lblPrice = new JLabel("SalePrice: " + product.getSalesPrice());
		
		String typeText = "";
		
		if(product.getClass() == Product.class) {
		
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
					new RowSpec[] {
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.NARROW_LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));

			panel.add(lblPurprice, "2, 3");
			panel.add(lblPrice, "4, 3");
			
			typeText = "N/A";
		} else {
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),
					FormFactory.LABEL_COMPONENT_GAP_COLSPEC,},
				new RowSpec[] {
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.NARROW_LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.NARROW_LINE_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			
			String text1 = "";
			String text2 = "";
			
			if(product instanceof Clothing) {
				text1 = "Colour: " + ((Clothing) product).getColour();
				text2 = "Size: " + ((Clothing) product).getSize();
				typeText = "Clothing";
			}
			if(product instanceof Equipment) {
				text1 = "Type: " + ((Equipment) product).getType();
				text2 = "Desc: " + ((Equipment) product).getDescription();
				typeText = "Equipment";
			}
			if(product instanceof GunReplica) {
				text1 = "Fabric: " + ((GunReplica) product).getFabric();
				text2 = "Calibre: " + ((GunReplica) product).getCalibre();
				typeText = "GunReplica";
			}
			
			JLabel lblSubclass_1 = new JLabel(text1);
			panel.add(lblSubclass_1, "2, 3");
			
			JLabel lblSubclass = new JLabel(text2);
			panel.add(lblSubclass, "4, 3");
			
			panel.add(lblPurprice, "2, 5");
			panel.add(lblPrice, "4, 5");
		}
		
		JLabel lblNewLabel_1 = new JLabel("Type: " + typeText);
		panel.add(lblNewLabel_1, "2, 1");
		
		JLabel lblNewLabel = new JLabel("Stock: " + product.getStock());
		panel.add(lblNewLabel, "4, 1");
		
	}

}
