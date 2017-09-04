package net.qcollins;

public class Dime extends Currency {
	private DollarAmount value;
	private String name;
	
	public Dime(DollarAmount value, String name) {
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