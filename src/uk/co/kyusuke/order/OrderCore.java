package uk.co.kyusuke.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import uk.co.kyusuke.Status;
import uk.co.kyusuke.database.DatabaseCore;

public class OrderCore implements Order {
	
	Order db = new DatabaseCore();
	
	@Override
	public void addOrder(int[] itemList,
			int quantity, int datePlaced, Status status,
			int assignedTo, String address, BigDecimal totalPrice){
		
	}

	@Override
	public List<Map<String, String>> listOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> viewOrder(int order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderStatus(int orderId, Status status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accessDB() {
		// TODO Auto-generated method stub
		
	}
}
