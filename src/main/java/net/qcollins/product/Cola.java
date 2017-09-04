package net.qcollins.product;

import net.qcollins.DollarAmount;

public class Cola extends VendingMachineItem{

	public Cola(String itemName, DollarAmount itemPrice) {
		super("Cola", new DollarAmount(100));

	}
}
