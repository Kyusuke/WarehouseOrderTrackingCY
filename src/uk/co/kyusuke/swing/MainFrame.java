package uk.co.kyusuke.swing;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Dimension;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8370890588381146147L;
	
	private CustomerOrderDetail customerOrderDetail = new CustomerOrderDetail(MainFrame.this);
	private CustomerOrderList customerOrderList = new CustomerOrderList(MainFrame.this);
	private Menu menuPanel = new Menu(MainFrame.this); 
	private Welcome welcomePanel = new Welcome(MainFrame.this);
	 
	private JPanel panelContainer = new JPanel();
	CardLayout cl = new CardLayout();

	/**
	 * Create the frame.
	 */
	
	public MainFrame() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Order Manager");
		Dimension d = new Dimension(400,140);
		setSize(d);
		
		panelContainer.setLayout(cl);
		panelContainer.add(customerOrderDetail, "customerOrderDetail");
		panelContainer.add(customerOrderList, "customerOrderList");
		panelContainer.add(welcomePanel, "welcome");
		panelContainer.add(menuPanel, "menu");
		cl.show(panelContainer, "welcome");
		
		add(panelContainer);
		setVisible(true);
	}

	private void changePanel(String panelName, Dimension d){
		cl.show(panelContainer, panelName);
		setSize(d);
	}
	
	public void showWelcome(){
		Dimension d = new Dimension(400,140);
		changePanel("welcome", d);
	}
	
	public void showMenu(){
		Dimension d = new Dimension(465,185);
		changePanel("menu", d);
	}
	
	public void showCustomerOrderDetail(){
		Dimension d = new Dimension(580,400);
		changePanel("customerOrderDetail", d);
	}
	
	public void showCustomerOrderList(){
		Dimension d = new Dimension(580,330);
		changePanel("customerOrderList", d);
	}
}