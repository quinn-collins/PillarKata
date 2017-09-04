package net.qcollins;

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
