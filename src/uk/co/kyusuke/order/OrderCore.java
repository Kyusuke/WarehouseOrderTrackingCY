package uk.co.kyusuke.order;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.kyusuke.data.EmployeeData;
import uk.co.kyusuke.data.OrderData;
import uk.co.kyusuke.data.OrderDetailData;
import uk.co.kyusuke.data.ProductData;
import uk.co.kyusuke.data.Status;
import uk.co.kyusuke.data.StockOrderData;
import uk.co.kyusuke.data.StockOrderDetailData;
import uk.co.kyusuke.database.DatabaseCore;

public class OrderCore implements Order {
	
	public void addCustomerOrder(OrderDetailData orderDetail){
		
	}

	public List<OrderData> listCustomerOrder() throws SQLException {
		Order db = new DatabaseCore();
		List<OrderData> odl = db.listCustomerOrder();
		return odl;
	}

	public OrderDetailData viewCustomerOrder(int order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateCustomerOrderStatus(int orderId, Status status) {
		// TODO Auto-generated method stub
		
	}

	public void assignOrder(int orderId, int employeeId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public List<EmployeeData> listEmployee() throws SQLException {
		Order db = new DatabaseCore();
		List<EmployeeData> employeeList = db.listEmployee();
		return employeeList;
	}
	
	public Map<Integer, String> employeeMap() throws SQLException {
		List<EmployeeData> employeeList = listEmployee();
		Map<Integer, String> employeeMap = new HashMap<Integer, String>();
		employeeMap.put(0, "Not Assigned");
		for(EmployeeData ed : employeeList){
			employeeMap.put(ed.getEmployeeId(), ed.getName());
		}
		return employeeMap;
	}

	public List<ProductData> listProduct() throws SQLException {
		Order db = new DatabaseCore();
		List<ProductData> productList = db.listProduct();
		return productList;
	}

	public Map<Integer, String> productMap() throws SQLException {
		List<ProductData> productList = listProduct();
		Map<Integer, String> productMap = new HashMap<Integer, String>();
		for(ProductData pd : productList){
			productMap.put(pd.getProductId(), pd.getName());
		}
		return productMap;
	}
	
	public ProductData viewProduct(int productId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateStock(int productId, int stock, int reservedStock)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void addDeliveryOrder(StockOrderDetailData orderDetail)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public List<StockOrderData> listDeliveryOrder() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public StockOrderDetailData viewDeliveryOrder(int orderId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateDeliveryOrderStatus(int orderId, Status status)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
