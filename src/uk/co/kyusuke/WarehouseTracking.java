package uk.co.kyusuke;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import uk.co.kyusuke.data.EmployeeData;
import uk.co.kyusuke.data.OrderDetailData;
import uk.co.kyusuke.data.ProductListData;
import uk.co.kyusuke.order.Order;
import uk.co.kyusuke.swing.MainFrame;


public class WarehouseTracking {
	//static Order order = new DatabaseCore();
	public static WarehouseModel model = new WarehouseModel();

	public static void main(String[] args) throws SQLException {
		/*List<ProductListData> pld = new ArrayList<>();
		pld.add(new ProductListData(1,5));
		pld.add(new ProductListData(3,10));
		pld.add(new ProductListData(4,2));
		OrderDetailData od = new OrderDetailData(0, null, Status.PLACED, 0, "123 Fake Street", "Hai Guy", "A county", "AA00 1BB", new BigDecimal("432.30"), pld);
		order.addCustomerOrder(od);*/
		
		/*List<OrderData> odl = order.listOrder();
		for(int i=0;i<odl.size();i++){
			OrderData od = odl.get(i);
			System.out.println(od.getDatePlaced());
		}*/
		
		/*OrderDetailData od = order.viewOrder(5);
		System.out.println(od.getAddress());*/
		
		//order.updateOrderStatus(5, Status.PROCESSING);
		
		//order.assignOrder(5, 2);
		
		/*List<EmployeeData> employee = order.listEmployee();
		for(int i=0; i<employee.size();i++){
			EmployeeData ed = employee.get(i);
			System.out.println(ed.getName());
		}*/
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public static WarehouseModel getModel(){
		return model;
	}
}
