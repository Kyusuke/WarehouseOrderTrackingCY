package uk.co.kyusuke.swing;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uk.co.kyusuke.WarehouseTracking;
import uk.co.kyusuke.data.OrderData;
import uk.co.kyusuke.data.WarehouseModel;
import uk.co.kyusuke.order.Order;
import uk.co.kyusuke.order.OrderCore;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerOrderList extends JPanel {
	private JTable tbCustomerOrderList;
	private Order order = new OrderCore();

	/**
	 * Create the panel.
	 */
	public CustomerOrderList(MainFrame mFrame) {
		setLayout(null);
		
		JLabel lblCustomerOrderList = new JLabel("Customer Order List");
		lblCustomerOrderList.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerOrderList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCustomerOrderList.setBounds(164, 11, 204, 40);
		add(lblCustomerOrderList);
		
		JButton btnViewDetails = new JButton("View Details");
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbCustomerOrderList.getSelectedRow() != -1){
					String orderId = (String) tbCustomerOrderList.getValueAt(tbCustomerOrderList.getSelectedRow(), 0);
					WarehouseModel model = WarehouseTracking.getModel();
					model.setCustomerOrderId(Integer.valueOf(orderId));
					
					mFrame.showCustomerOrderDetail();
				}
			}
		});
		btnViewDetails.setBounds(375, 259, 165, 30);
		add(btnViewDetails);
		
		addComponentListener(new CustomComponentListener());
	}
	
	private class CustomComponentListener implements ComponentListener{

		@Override
		public void componentHidden(ComponentEvent arg0) {
			panelHideOperations();
		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
			try {
				panelShowOperations();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void panelShowOperations() throws SQLException{
			DefaultTableModel orderModel = new DefaultTableModel();
			orderModel.addColumn("Order ID");
			orderModel.addColumn("Time Placed");
			orderModel.addColumn("Status");
			orderModel.addColumn("Assigned to");
			
			List<OrderData> odl = order.listCustomerOrder();
			Map<Integer, String> employeeMap = order.employeeMap();
			
			for(OrderData od : odl){
				orderModel.addRow(new Object[]{String.valueOf(od.getOrderId()),
						od.getDatePlaced().toString(),
						od.getStatus().toString(),
						employeeMap.get(od.getAssignedTo())
						});
			}
			
			tbCustomerOrderList = new JTable(orderModel);
			
			JScrollPane sbOrderList = new JScrollPane(tbCustomerOrderList);
			sbOrderList.setBounds(10, 62, 530, 186);
			add(sbOrderList);
		}
		
		private void panelHideOperations(){
			if(tbCustomerOrderList != null){
				remove(tbCustomerOrderList);
				revalidate();
			}
		}
	}
}
