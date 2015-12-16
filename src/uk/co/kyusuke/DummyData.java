package uk.co.kyusuke;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyData {

	List<Map<String, String>> orderData = new ArrayList<>();
	
	/*public DummyData(){
		setOrder("000","12345,1231,121211","121,12,50","1450111219",Status.PROCESSING);
		setOrder("001","12211,112,123451","50,60,40","1450112043",Status.CANCELLED);
		setOrder("002","12312,1213,12312","30,30,30","1450113029",Status.DELIVERING);
	}	
	
	public void setOrder(int[] itemList,
			int quantity, Date datePlaced, Status status,
			int assignedTo, String address, BigDecimal totalPrice)
	{ 
		Map<String, String> map = new HashMap<String, String>();
		map.put("itemList", Arrays.toString(itemList));
		map.put("quantity", Integer.toString(quantity));
		map.put("datePlaced", datePlaced.toString());
		map.put("status", status.name());
		orderData.add(map);
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
	}*/
}