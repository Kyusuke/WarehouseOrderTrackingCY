package uk.co.kyusuke.order;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uk.co.kyusuke.data.EmployeeData;
import uk.co.kyusuke.data.OrderData;
import uk.co.kyusuke.data.OrderDetailData;
import uk.co.kyusuke.data.ProductData;
import uk.co.kyusuke.data.ProductListData;
import uk.co.kyusuke.data.Status;
import uk.co.kyusuke.data.StockOrderData;
import uk.co.kyusuke.data.StockOrderDetailData;

public interface Order {
	public void addCustomerOrder(OrderDetailData orderDetail) throws SQLException;
	
	public List<OrderData> listCustomerOrder() throws SQLException;
	
	public OrderDetailData viewCustomerOrder(int orderId) throws SQLException;
	
	public void updateCustomerOrderStatus(int orderId, Status status) throws SQLException;
	
	public void assignOrder(int orderId, int employeeId) throws SQLException;
	
	public List<EmployeeData> listEmployee() throws SQLException;
	
	public Map<Integer, String> employeeMap() throws SQLException;
	
	public List<ProductData> listProduct() throws SQLException;
	
	public Map<Integer, String> productMap() throws SQLException;
	
	public ProductData viewProduct(int productId) throws SQLException;
	
	public void updateStock(int productId, int stock, int reservedStock) throws SQLException;
	
	public void addDeliveryOrder(StockOrderDetailData orderDetail) throws SQLException;
	
	public List<StockOrderData> listDeliveryOrder() throws SQLException;
	
	public StockOrderDetailData viewDeliveryOrder(int orderId) throws SQLException;
	
	public void updateDeliveryOrderStatus(int orderId, Status status) throws SQLException;
}
