package uk.co.kyusuke.data;

import java.util.Date;
import java.util.List;

import uk.co.kyusuke.Status;

public class StockOrderDetailData extends StockOrderData{
	private List<StockOrderListData> stockList;
	
	public StockOrderDetailData(int orderId, Status status, Date timePlaced, List<StockOrderListData> stockList){
		super(orderId, status, timePlaced);
		this.stockList = stockList;
	}

	public List<StockOrderListData> getOrderList(){ return stockList; }
}
