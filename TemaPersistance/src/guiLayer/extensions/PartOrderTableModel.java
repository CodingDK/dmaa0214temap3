package guiLayer.extensions;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelLayer.PartOrder;

public class PartOrderTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private ArrayList<PartOrder> items;
	
	public PartOrderTableModel(){}
	
	public PartOrderTableModel(ArrayList<PartOrder> it) {
		items = it;
	}
	
	public void refresh(ArrayList<PartOrder> it) {
		items = it;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public int getRowCount() {
		return items.size();
	}
	
	public Object getValueAt(int rowIndex, int collIndex) {
		PartOrder o = items.get(rowIndex);
		Object value = null;
		if (collIndex == 0) {
			value = o.getProduct().getId();
		} else if (collIndex == 1) {
			value = o.getProduct().getName();
		} else if (collIndex == 2) {
			value = o.getAmount();
		} else if (collIndex == 3) {
			value = o.getUnitPrice();
		}
		
		return value;
	}
	
	@Override
	public String getColumnName(int collIndex) {
		
		String value = "??";
		
		if (collIndex == 0) {
			value = "ID";
		} else if (collIndex == 1) {
			value = "Name";
		} else if (collIndex == 2) {
			value = "Amount";
		} else if (collIndex == 3) {
			value = "Unit Price";
		} 
		return value;
	}

}
