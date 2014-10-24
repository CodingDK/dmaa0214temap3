package dbLayer;

import java.util.ArrayList;

import modelLayer.Order;
import modelLayer.PartOrder;

public interface IFDBPartOrder {
	
	// Get PartSale by Order
	public ArrayList<PartOrder> findPartOrders(Order order, boolean retAsso);
	
	// Insert multiple PartOrders
	public boolean insertPartOrders(ArrayList<PartOrder> partOrders);
	
	// Update a PartOrder
	public int updatePartOrder(PartOrder pOrder);
	
	// Remove PartOrder
	public int removePartOrder(PartOrder pORder);
}
