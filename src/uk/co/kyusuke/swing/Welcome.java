package uk.co.kyusuke.swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import uk.co.kyusuke.WarehouseTracking;
import uk.co.kyusuke.data.EmployeeData;
import uk.co.kyusuke.order.Order;
import uk.co.kyusuke.order.OrderCore;
import uk.co.kyusuke.swing.adapter.EmployeeListCellRenderer;

public class Welcome extends JPanel {

	private Order order = new OrderCore();
	/**
	 * 
	 */
	private static final long serialVersionUID = 2245998049277309672L;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Welcome(MainFrame mFrame) throws SQLException {
		setLayout(null);
		//setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblWelcome = new JLabel("<html>Welcome!\r\n<br>Please sign in");
		lblWelcome.setBounds(10, 11, 122, 50);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblWelcome);
		
		JComboBox cbbEmployee = new JComboBox();
		cbbEmployee.setBounds(10, 72, 228, 21);
		cbbEmployee.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		List<EmployeeData> employeeList = order.listEmployee();
		for(EmployeeData employee : employeeList)
		{
			cbbEmployee.addItem(employee);
		}
		cbbEmployee.setRenderer(new EmployeeListCellRenderer());
		add(cbbEmployee);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(248, 71, 93, 23);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeData employee = (EmployeeData) cbbEmployee.getSelectedItem();
				WarehouseTracking.employee = employee;
				
				Dimension d = new Dimension(465,185);
				mFrame.changePanel("menu", d);
			}
		});
		add(btnSignIn);
	}
}
