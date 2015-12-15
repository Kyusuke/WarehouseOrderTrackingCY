package uk.co.kyusuke.database;

import java.util.List;
import java.util.Map;

import uk.co.kyusuke.DummyData;
import uk.co.kyusuke.Status;
import uk.co.kyusuke.order.Order;

public class DatabaseCore implements Order{
	
	DummyData dummyData = new DummyData();
			
	public void addOrder(String orderId, String itemList,
			String quantity, String datePlaced, Status status){
		dummyData.setOrder(orderId, itemList, quantity, datePlaced, status);
	}
	
	public List<Map<String, String>> listOrder(){
		return dummyData.getOrderList();
	}
	
	public Map<String, String> viewOrder(int orderId){
		return dummyData.getOrder(orderId);
	}
	
	public void updateOrderStatus(int orderId, Status status){
		dummyData.updateOrderStatus(orderId, status);
	}
}
