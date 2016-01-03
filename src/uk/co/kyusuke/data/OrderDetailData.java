package uk.co.kyusuke.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import uk.co.kyusuke.Status;

public class OrderDetailData extends OrderData{
	private List<ProductListData> productList;
	
	public OrderDetailData(int orderId, Date datePlaced, Status status,
			int assignedTo, String address, String town, String county,
			String postCode, BigDecimal totalPrice, List<ProductListData> productList) {
		super(orderId, datePlaced, status, assignedTo, address, town, county, postCode,
				totalPrice);
		this.productList = productList;
	}

	public List<ProductListData> getProductList(){ return productList; }
}
