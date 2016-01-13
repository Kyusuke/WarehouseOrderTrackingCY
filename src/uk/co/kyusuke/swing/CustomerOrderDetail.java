package uk.co.kyusuke.swing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CustomerOrderDetail extends JPanel {

	/**
	 * Create the panel.
	 */
	public CustomerOrderDetail(MainFrame mFrame) {
		setLayout(null);
		
		JLabel lblOrderDetails = new JLabel("Order Details");
		lblOrderDetails.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblOrderDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderDetails.setBounds(193, 11, 183, 55);
		add(lblOrderDetails);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mFrame.showCustomerOrderList();
			}
		});
		btnBack.setBounds(10, 11, 91, 23);
		add(btnBack);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setBounds(10, 81, 91, 23);
		add(lblOrderId);
		
		JLabel lblDatePlaced = new JLabel("Date Placed");
		lblDatePlaced.setBounds(10, 115, 91, 23);
		add(lblDatePlaced);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 149, 91, 23);
		add(lblStatus);
		
		JLabel lblAssignedTo = new JLabel("Assigned To");
		lblAssignedTo.setBounds(10, 183, 91, 23);
		add(lblAssignedTo);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(273, 81, 80, 23);
		add(lblAddress);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setBounds(273, 115, 82, 23);
		add(lblTown);
		
		JLabel lblCounty = new JLabel("County");
		lblCounty.setBounds(273, 153, 80, 19);
		add(lblCounty);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setBounds(273, 187, 80, 19);
		add(lblPostcode);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 550, 119);
		add(scrollPane);
		
	}
}
