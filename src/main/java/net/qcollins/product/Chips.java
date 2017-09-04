package net.qcollins.product;

import net.qcollins.DollarAmount;

public class Chips extends VendingMachineItem{

	public Chips(String itemName, DollarAmount itemPrice) {
		super("Chips", new DollarAmount(50));

	}
}