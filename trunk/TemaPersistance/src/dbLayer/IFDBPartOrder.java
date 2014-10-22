package dbLayer;

import java.util.ArrayList;

import modelLayer.Order;
import modelLayer.PartOrder;

public interface IFDBPartOrder {
	
	// Get PartSale by Order
	public ArrayList<PartOrder> findPartOrders(Order order, boolean retAsso);
	
	// Insert new PartOrder
	public int insertPartOrder(PartOrder pOrder);
	
	// Update a PartOrder
	public int updatePartOrder(PartOrder pOrder);
	
	// Remove PartOrder
	public int removePartOrder(PartOrder pORder);
}
