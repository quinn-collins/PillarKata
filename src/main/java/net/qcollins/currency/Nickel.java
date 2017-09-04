package net.qcollins.currency;

import net.qcollins.DollarAmount;

public class Nickel extends Currency {
	private DollarAmount value;
	private String name;
	
	public Nickel(DollarAmount value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public DollarAmount getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
}