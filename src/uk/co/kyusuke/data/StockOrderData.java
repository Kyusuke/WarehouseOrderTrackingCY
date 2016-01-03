package uk.co.kyusuke.data;

import java.util.Date;

import uk.co.kyusuke.Status;

public class StockOrderData {
	private int stockDeliveryId;
	private Status status;
	private Date timePlaced;
	
	public StockOrderData(int stockDeliveryId, Status status, Date timePlaced){
		this.stockDeliveryId = stockDeliveryId;
		this.status = status;
		this.timePlaced = timePlaced;
	}
	
	public int getStockDeliveryId() { return stockDeliveryId; }
	public Status getStatus() { return status; }
	public Date getTimePlaced() { return timePlaced; }
}
