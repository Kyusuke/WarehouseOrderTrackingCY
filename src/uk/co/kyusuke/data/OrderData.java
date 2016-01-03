package uk.co.kyusuke.data;

import java.math.BigDecimal;
import java.util.Date;

public class OrderData {
	private int orderId;
	private Date datePlaced;
	private Status status;
	private int assignedTo;
	private String address;
	private String town;
	private String county;
	private String postCode;
	private BigDecimal totalPrice;
	
	public OrderData(int orderId, Date datePlaced, Status status, int assignedTo, String address, String town, String county, String postCode, BigDecimal totalPrice){
		this.orderId = orderId;
		this.datePlaced = datePlaced;
		this.status = status;
		this.assignedTo = assignedTo;
		this.address = address;
		this.town = town;
		this.county = county;
		this.postCode = postCode;
		this.totalPrice = totalPrice;
	}
	
	public int getOrderId() {return orderId;}
	public Date getDatePlaced() {return datePlaced;}
	public Status getStatus() {return status;}
	public int getAssignedTo() {return assignedTo;}
	public String getAddress() {return address;}
	public String getTown() {return town;}
	public String getCounty() {return county;}
	public String getPostCode() {return postCode;}
	public BigDecimal getTotalPrice() {return totalPrice;}
	
}
