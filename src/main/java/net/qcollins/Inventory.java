package net.qcollins;

import java.util.LinkedHashMap;
import java.util.Map;

import net.qcollins.product.VendingMachineItem;

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

	public void decreaseItemStock(VendingMachineItem item) {
		itemStock.put(item, itemStock.get(item).intValue()-1);
		
	}
}
