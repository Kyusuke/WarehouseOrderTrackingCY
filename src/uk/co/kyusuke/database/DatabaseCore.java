package uk.co.kyusuke.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.co.kyusuke.Status;
import uk.co.kyusuke.data.EmployeeData;
import uk.co.kyusuke.data.OrderData;
import uk.co.kyusuke.data.OrderDetailData;
import uk.co.kyusuke.data.ProductListData;
import uk.co.kyusuke.data.StockOrderData;
import uk.co.kyusuke.data.StockOrderDetailData;
import uk.co.kyusuke.data.StockOrderListData;
import uk.co.kyusuke.order.Order;

public class DatabaseCore implements Order{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/nbgardens";
	
	static final String USER = "root";
	static final String PASS = "bobby";
		
	static final String DB_EMPLOYEE = "employee";
	static final String DB_ORDER = "order";
	static final String DB_PRODUCT = "product";
	static final String DB_PRODUCTLIST = "productlist";
	static final String DB_STOCKDELIVERIES = "stockdeliveries";
	static final String DB_STOCKDELIVERYLIST = "stockdeliverylist";
	
	static final String EMPLOYEE_EMPLOYEEID = "employeeId";
	static final String EMPLOYEE_NAME = "name";

	static final String PRODUCT_PRODUCTID = "productId";
	static final String PRODUCT_NAME = "name";
	static final String PRODUCT_PRICE = "price";
	static final String PRODUCT_LOCATIONINWAREHOUSE = "locationInWarehouse";
	static final String PRODUCT_STOCK = "stock";
	static final String PRODUCT_RESERVEDSTOCK = "reservedStock";
	static final String PRODUCT_STOCKTHRESHOLD = "stockThreshold";
	
	static final String PRODUCTLIST_QUANTITY = "quantity";
	
	static final String ORDER_ORDERID = "orderId";
	static final String ORDER_TIMEPLACED = "timePlaced";
	static final String ORDER_STATUS = "status";
	static final String ORDER_ASSIGNEDTO = "assignedTo";
	static final String ORDER_ADDRESS = "address";
	static final String ORDER_TOWN = "town";
	static final String ORDER_COUNTY = "county";
	static final String ORDER_POSTCODE = "postCode";
	static final String ORDER_TOTALPRICE = "totalPrice";
	
	static final String STOCK_STOCKDELIVERYID = "stockDeliveryId";
	static final String STOCK_STATUS = "status";
	static final String STOCK_TIMEPLACED = "timePlaced";
	static final String STOCK_QUANTITY = "quantity";
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public DatabaseCore(){
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
		finally{

		}
	}
	
	public void addCustomerOrder(OrderDetailData orderDetail) throws SQLException{
		stmt = conn.createStatement();
		String orderQuery = "INSERT INTO `" + DB_ORDER + "`(`" + ORDER_STATUS + "`,`" + ORDER_ADDRESS + "`,`" + ORDER_TOWN + "`,`" + ORDER_COUNTY + "`,`" + ORDER_POSTCODE + "`,`" + ORDER_TOTALPRICE 
				+ "`) VALUES('" + orderDetail.getStatus() + "','" + orderDetail.getAddress() + "','" + orderDetail.getTown() + "','" + orderDetail.getCounty() + "','" + orderDetail.getPostCode() + "','" + orderDetail.getTotalPrice() + "');";
		stmt.executeUpdate(orderQuery, Statement.RETURN_GENERATED_KEYS);
		rs = stmt.getGeneratedKeys();
		int generatedId = 0;
		while(rs.next()){
			generatedId = rs.getInt(1);
		}
		List<ProductListData> pld = orderDetail.getProductList();
		for(ProductListData entry : pld){
			String productQuery = "INSERT INTO `" + DB_PRODUCTLIST + "`(`" + ORDER_ORDERID + "`,`" + PRODUCT_PRODUCTID + "`,`" + PRODUCTLIST_QUANTITY
					+ "`) VALUES('" + generatedId + "','" + String.valueOf(entry.getProductId()) + "','" + String.valueOf(entry.getQuantity()) + "');";
			stmt.executeUpdate(productQuery);
		}
		rs.close();
		conn.close();
	}
	
	public List<OrderData> listCustomerOrder() throws SQLException{
		stmt = conn.createStatement();
		String query = "SELECT * FROM `" + DB_ORDER + "`;";
		rs = stmt.executeQuery(query);
		List<OrderData> od = new ArrayList<>();
		while(rs.next()){
			od.add(new OrderData(rs.getInt(ORDER_ORDERID), 
					rs.getTimestamp(ORDER_TIMEPLACED), 
					Status.valueOf(rs.getString(ORDER_STATUS)),
					rs.getInt(ORDER_ASSIGNEDTO), 
					rs.getString(ORDER_ADDRESS), 
					rs.getString(ORDER_TOWN), 
					rs.getString(ORDER_COUNTY), 
					rs.getString(ORDER_POSTCODE), 
					rs.getBigDecimal(ORDER_TOTALPRICE)));
		}
		rs.close();
		conn.close();
		return od;
	}
	
	public OrderDetailData viewCustomerOrder(int orderId) throws SQLException {
		stmt = conn.createStatement();
		
		String orderQuery = "SELECT * FROM `" + DB_ORDER + "` WHERE `" + ORDER_ORDERID + "`='" + orderId + "';";
		String productListQuery = "SELECT * FROM `" + DB_PRODUCTLIST + "` WHERE `" + ORDER_ORDERID + "`='" + orderId + "';";
		
		rs = stmt.executeQuery(orderQuery);
		
		OrderData od = null;
		
		while(rs.next()){
			od = new OrderData(rs.getInt(ORDER_ORDERID), 
				rs.getTimestamp(ORDER_TIMEPLACED), 
				Status.valueOf(rs.getString(ORDER_STATUS)),
				rs.getInt(ORDER_ASSIGNEDTO), 
				rs.getString(ORDER_ADDRESS), 
				rs.getString(ORDER_TOWN), 
				rs.getString(ORDER_COUNTY), 
				rs.getString(ORDER_POSTCODE), 
				rs.getBigDecimal(ORDER_TOTALPRICE));
		}
		
		rs = stmt.executeQuery(productListQuery);
		
		List<ProductListData> productList = new ArrayList<>();
		while(rs.next()){
			productList.add(new ProductListData(rs.getInt(PRODUCT_PRODUCTID), rs.getInt(PRODUCTLIST_QUANTITY)));
		}
		
		OrderDetailData order = new OrderDetailData(od.getOrderId(),
				od.getDatePlaced(),
				od.getStatus(),
				od.getAssignedTo(),
				od.getAddress(),
				od.getTown(),
				od.getCounty(),
				od.getPostCode(),
				od.getTotalPrice(),
				productList);
		rs.close();
		conn.close();
		return order;
	}
	
	public void updateCustomerOrderStatus(int orderId, Status status) throws SQLException {
		stmt = conn.createStatement();
		
		String query = "UPDATE `" + DB_ORDER + "` SET `" + ORDER_STATUS + "`='" + status + "' WHERE `" + ORDER_ORDERID + "`='" + orderId + "';";
		stmt.executeUpdate(query);
		conn.close();
	}
	
	public void assignOrder(int orderId, int employeeId) throws SQLException {
		stmt = conn.createStatement();
		
		String query = "UPDATE `" + ORDER_ORDERID + "` SET `" + ORDER_ASSIGNEDTO + "`='" + employeeId + "' WHERE `" + ORDER_ORDERID + "`='" + orderId + "';";
		stmt.executeUpdate(query);
		conn.close();
	}
	
	public List<EmployeeData> listEmployee() throws SQLException {
		stmt = conn.createStatement();
		
		String query = "SELECT * FROM `" + DB_EMPLOYEE + "`;";
		rs = stmt.executeQuery(query);
		List<EmployeeData> employee = new ArrayList<>();
		while(rs.next()){
			employee.add(new EmployeeData(rs.getInt(EMPLOYEE_EMPLOYEEID),
					rs.getString(EMPLOYEE_NAME)));
		}
		return employee;
	}
	
	public void updateStock(int productId, int stock, int reservedStock) throws SQLException {
		stmt = conn.createStatement();
		
		String query = "UPDATE `" + DB_PRODUCT + "` SET `" + PRODUCT_STOCK + "`='" + stock + "', `" + PRODUCT_RESERVEDSTOCK + "`='" + reservedStock + "' WHERE `" + PRODUCT_PRODUCTID + "`='" + productId + "';";
		stmt.executeUpdate(query);
		conn.close();
	}

	
	public void addDeliveryOrder(StockOrderDetailData orderDetail) throws SQLException {
		stmt = conn.createStatement();
		String orderQuery = "INSERT INTO `" + DB_STOCKDELIVERIES + "`(`" + STOCK_STATUS
				+ "`) VALUES ('" + orderDetail.getStatus() + "');";
		stmt.executeUpdate(orderQuery, Statement.RETURN_GENERATED_KEYS);
		rs = stmt.getGeneratedKeys();
		int generatedId = 0;
		while(rs.next()){
			generatedId = rs.getInt(1);
		}
		List<StockOrderListData> sold = orderDetail.getOrderList();
		for(StockOrderListData entry : sold){
			String stockEntry = "INSERT INTO `" + DB_STOCKDELIVERYLIST + "`(`" + STOCK_STOCKDELIVERYID + "`,`" + PRODUCT_PRODUCTID + "`,`" + STOCK_QUANTITY
					+ "`) VALUES('" + generatedId + "','" + String.valueOf(entry.getProductId()) + "','" + String.valueOf(entry.getQuantity()) + "');";
			stmt.executeUpdate(stockEntry);
		}
		rs.close();
		conn.close();
	}

	
	public List<StockOrderData> listDeliveryOrder() throws SQLException {
		stmt = conn.createStatement();
		String query = "SELECT * FROM `" + DB_STOCKDELIVERIES + "`;";
		rs = stmt.executeQuery(query);
		List<StockOrderData> od = new ArrayList<>();
		while(rs.next()){
			od.add(new StockOrderData(rs.getInt(STOCK_STOCKDELIVERYID),
					Status.valueOf(rs.getString(STOCK_STATUS)),
					rs.getTimestamp(STOCK_TIMEPLACED)));
		}
		rs.close();
		conn.close();
		return od;
	}

	
	public StockOrderDetailData viewDeliveryOrder(int orderId) throws SQLException {
		stmt = conn.createStatement();
		
		String orderQuery = "SELECT * FROM `" + DB_PRODUCT + "` WHERE `" + PRODUCT_PRODUCTID + "`='" + orderId + "';";
		String stockListQuery = "SELECT * FROM `" + DB_PRODUCTLIST + "` WHERE `" + PRODUCT_PRODUCTID + "`='" + orderId + "';";
		
		rs = stmt.executeQuery(orderQuery);
		
		StockOrderData od = null;
		
		while(rs.next()){
			od = new StockOrderData(rs.getInt(STOCK_STOCKDELIVERYID),
					Status.valueOf(rs.getString(STOCK_STATUS)),
					rs.getTimestamp(STOCK_TIMEPLACED));
		}
		
		rs = stmt.executeQuery(stockListQuery);
		
		List<StockOrderListData> stockOd = new ArrayList<>();
		while(rs.next()){
			stockOd.add(new StockOrderListData(rs.getInt(PRODUCT_PRODUCTID), rs.getInt(STOCK_QUANTITY)));
		}
		
		StockOrderDetailData stockDetail = new StockOrderDetailData(od.getStockDeliveryId(),
				od.getStatus(),
				od.getTimePlaced(),
				stockOd);
		
		rs.close();
		conn.close();
		
		return stockDetail;
	}

	
	public void updateDeliveryOrderStatus(int orderId, Status status) throws SQLException {
		stmt = conn.createStatement();
		
		String query = "UPDATE `" + DB_STOCKDELIVERIES + "` SET `" + STOCK_STATUS + "`='" + status + "' WHERE `" + STOCK_STOCKDELIVERYID + "`='" + orderId + "';";
		stmt.executeUpdate(query);
		conn.close();
	}

	
}
