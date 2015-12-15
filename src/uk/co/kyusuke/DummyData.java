package uk.co.kyusuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyData {

	List<Map<String, String>> orderData = new ArrayList<>();
	
	public DummyData(){
		setOrder("000","12345,1231,121211","121,12,50","1450111219",Status.PROCESSING);
		setOrder("001","12211,112,123451","50,60,40","1450112043",Status.CANCELLED);
		setOrder("002","12312,1213,12312","30,30,30","1450113029",Status.DELIVERING);
	}	
	
	public void setOrder(String orderId, String itemList,
			String quantity, String datePlaced, Status status)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("orderId", orderId);
		map.put("itemList", itemList);
		map.put("quantity", quantity);
		map.put("datePlaced", datePlaced);
		map.put("status", status.name());
		orderData.add(Integer.parseInt(orderId),map);
	}
	
	public List<Map<String, String>> getOrderList(){
		return orderData;
	}
	
	public Map<String, String> getOrder(int orderId){
		return orderData.get(orderId);
	}
	
	public void updateOrderStatus(int orderId, Status status){
		Map<String, String> order = orderData.get(orderId);
		order.put("status", status.name());
		orderData.set(orderId, order);
	}
}