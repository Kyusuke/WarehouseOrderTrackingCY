package uk.co.kyusuke.data;

public class ProductListData {
	private int productId;
	private int quantity;
	
	public ProductListData(int productId, int quantity){
		this.productId = productId;
		this.quantity = quantity;
	}
		
	public int getProductId() { return productId;}
	public int getQuantity() {return quantity;}

}
