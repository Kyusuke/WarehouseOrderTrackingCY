package uk.co.kyusuke.data;

import java.math.BigDecimal;

public class ProductData {
	private int productId;
	private String name;
	private BigDecimal price;
	private String locationInWarehouse;
	private int stock;
	private int reservedStock;
	private int stockThreshold;
	
	public ProductData(int productId, String name, BigDecimal price,
			String locationInWarehouse, int stock, int reservedStock, int stockThreshold){
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.locationInWarehouse = locationInWarehouse;
		this.stock = stock;
		this.reservedStock = reservedStock;
		this.stockThreshold = stockThreshold;
	}
	
	 public int getProductId() { return productId; }
	 public String getName() { return name; }
	 public BigDecimal getPrice() { return price; }
	 public String getLocationInWarehouse() { return locationInWarehouse; }
	 public int getStock() { return stock; }
	 public int getReservedStock() { return reservedStock; }
	 public int getStockThreshold() { return stockThreshold; }
}
