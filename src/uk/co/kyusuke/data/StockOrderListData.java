package uk.co.kyusuke.data;

public class StockOrderListData {
	private int productId;
	private int quantity;
	
	public StockOrderListData(int productId, int quantity){
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public int getProductId() { return productId; }
	public int getQuantity() { return quantity; }
}
