package net.qcollins.product;

import net.qcollins.DollarAmount;

public abstract class VendingMachineItem {
	
	private String itemName;
	private DollarAmount itemPrice;
	
	
	public VendingMachineItem(String itemName, DollarAmount itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public DollarAmount getItemPrice() {
		return itemPrice;
	}
}
