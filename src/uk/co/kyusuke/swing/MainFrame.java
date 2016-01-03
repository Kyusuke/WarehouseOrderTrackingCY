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
		panelContainer.add(welcomePanel, "welcome");
		panelContainer.add(menuPanel, "menu");
		cl.show(panelContainer, "welcome");
		
		add(panelContainer);
		setVisible(true);
	}

	public void changePanel(String panelName, Dimension d){
		menuPanel.revalidate();
		cl.show(panelContainer, panelName);
		setSize(d);
	}
}

/*//setBounds(100, 100, 395, 165);

getContentPane().add(welcomePanel);
setLayout(null);*/