package net.qcollins.product;

import net.qcollins.DollarAmount;

public class Candy extends VendingMachineItem{

	public Candy(String itemName, DollarAmount itemPrice) {
		super("Candy", new DollarAmount(65));

	}
}