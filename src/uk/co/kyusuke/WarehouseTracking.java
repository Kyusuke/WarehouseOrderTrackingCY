package uk.co.kyusuke;

import uk.co.kyusuke.database.DatabaseCore;
import uk.co.kyusuke.order.Order;

public class WarehouseTracking {
	static Order db = new DatabaseCore();
	
	public static void main(String[] args) {
		db.accessDB();
	}

}
