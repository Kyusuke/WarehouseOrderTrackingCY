package uk.co.kyusuke.swing;

import javax.swing.JPanel;
import javax.swing.JLabel;

import uk.co.kyusuke.WarehouseTracking;
import uk.co.kyusuke.data.EmployeeData;
import uk.co.kyusuke.data.WarehouseModel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JPanel {

	JLabel lblWelcome;
	
	/**
	 * Create the panel.
	 */
	public Menu(MainFrame mFrame) {

		setLayout(null);
		
		JLabel lblChooseATask = new JLabel("Choose a task");
		lblChooseATask.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblChooseATask.setBounds(265, 11, 175, 59);
		add(lblChooseATask);
		
		JButton btnViewCustomerOrders = new JButton("<html>View Customer Orders");
		btnViewCustomerOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mFrame.showCustomerOrderList();
			}
		});
		btnViewCustomerOrders.setBounds(10, 81, 125, 59);
		add(btnViewCustomerOrders);
		
		JButton btnViewProducts = new JButton("<html>View Products");
		btnViewProducts.setBounds(157, 81, 125, 59);
		add(btnViewProducts);
		
		JButton btnViewDeliveryOrders = new JButton("<html>View Delivery Orders");
		btnViewDeliveryOrders.setBounds(307, 81, 119, 59);
		add(btnViewDeliveryOrders);
		
		JButton btnChangeUser = new JButton("Change User");
		btnChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mFrame.showWelcome();
			}
		});
		btnChangeUser.setBounds(10, 36, 110, 23);
		add(btnChangeUser);

		addComponentListener(new CustomComponentListener());
	}
	
	private class CustomComponentListener implements ComponentListener{

		@Override
		public void componentHidden(ComponentEvent e) {
			panelHideOperations();
		}

		@Override
		public void componentMoved(ComponentEvent e) {

		}

		@Override
		public void componentResized(ComponentEvent e) {
	
		}

		@Override
		public void componentShown(ComponentEvent e) {
			panelShowOperations();
		}
	}
	
	private void panelShowOperations(){
		WarehouseModel model = WarehouseTracking.getModel();
		EmployeeData employee = model.getEmployee();
		lblWelcome = new JLabel("Welcome " + employee.getName());
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcome.setBounds(10, 11, 245, 20);
		add(lblWelcome);
	}
	
	private void panelHideOperations(){
		if(lblWelcome != null){
			remove(lblWelcome);
			revalidate();
		}
	}
}
