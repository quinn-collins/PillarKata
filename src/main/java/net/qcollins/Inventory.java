package net.qcollins;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {
	
	private Map<VendingMachineItem, Integer> itemStock;
	
	public Inventory() {
		itemStock = new LinkedHashMap<VendingMachineItem, Integer>();
	}

	public Map<VendingMachineItem, Integer> getItemStock() {
		return itemStock;
	}

	public void setItemStock(Map<VendingMachineItem, Integer> itemStock) {
		this.itemStock = itemStock;
	}
}
