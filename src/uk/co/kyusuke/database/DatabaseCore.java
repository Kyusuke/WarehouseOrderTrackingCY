package uk.co.kyusuke.database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import uk.co.kyusuke.Status;
import uk.co.kyusuke.order.Order;

public class DatabaseCore implements Order{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/nbgardens";
	
	static final String USER = "root";
	static final String PASS = "bobby";
	
	public void accessDB(){
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connection attempt");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println(conn);
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
	public void addOrder(int[] itemList,
			int quantity, int datePlaced, Status status,
			int assignedTo, String address, BigDecimal totalPrice){
	}
	
	public List<Map<String, String>> listOrder(){
		return null;
	}
	
	public Map<String, String> viewOrder(int orderId){
		return null;
	}
	
	public void updateOrderStatus(int orderId, Status status){
		
	}
	
}
