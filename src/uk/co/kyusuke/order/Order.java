package uk.co.kyusuke.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import uk.co.kyusuke.Status;

public interface Order {
	public void addOrder(int[] itemList,
			int quantity, int datePlaced, Status status,
			int assignedTo, String address, BigDecimal totalPrice);
	
	public List<Map<String, String>> listOrder();
	
	public Map<String, String> viewOrder(int order);
	
	public void updateOrderStatus(int orderId, Status status);
}
