package net.qcollins.currency;

import net.qcollins.DollarAmount;

public abstract class Currency {

	private DollarAmount value;
	private String name;

	public String getName() {
		return name;
	}
	
	public DollarAmount getValue() {
		return value;
	}
}
