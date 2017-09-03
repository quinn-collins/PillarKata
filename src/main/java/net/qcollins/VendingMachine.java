package net.qcollins;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	private CoinIdentifier coinIdentifier;
	private DollarAmount currentBalance = new DollarAmount(0);
	private List<String> coinTray;
	private String display;
	private Inventory inventory;
	private VendingMachineItem cola;
	private VendingMachineItem chips;
	private VendingMachineItem candy;
	
	public List<String> getCoinTray() {
		return coinTray;
	}

	public VendingMachine(CoinIdentifier coinIdentifier, Inventory inventory) {
		this.coinIdentifier = coinIdentifier;
		this.inventory = inventory;
		coinTray = new ArrayList<String>();
		cola = new Cola("Cola", new DollarAmount(100));
		chips = new Chips("Chips", new DollarAmount(50));
		candy = new Candy("Candy", new DollarAmount(65));
		
	}
	
	public DollarAmount getCurrentBalance() {
		return currentBalance;
	}
	
	public void insertCoin(double mass, double diameter, double thickness) {
		String coin = coinIdentifier.identify(mass, diameter, thickness);
		if(coin.equals("quarter")) {
			currentBalance = currentBalance.plus(new DollarAmount(25));
			setDisplay(currentBalance.toString());
		}
		else if(coin.equals("dime")) {
			currentBalance = currentBalance.plus(new DollarAmount(10));
			setDisplay(currentBalance.toString());
		}
		else if(coin.equals("nickel")) {
			currentBalance = currentBalance.plus(new DollarAmount(5));
			setDisplay(currentBalance.toString());
		}
		else {
			coinTray.add(coin);
		}
		
	}

	public String getDisplay() {
		return display;
	}
	
	public String getDisplayAgain() {
		if(currentBalance.compareTo(new DollarAmount(0))==0) {
			setDisplay(DisplayMessage.INSERT_COINS.getMessage());
		}
		else {
			setDisplay(currentBalance.toString());
		}
		return display;
	}
	
	public void setDisplay(String display) {
		this.display = display;
	}

	public void pressButton(String string) {
		if(string == "COLA") {
			if(currentBalance.isLessThan(cola.getItemPrice())) {
				setDisplay("PRICE " + cola.getItemPrice());
			}
			else {
				setDisplay(DisplayMessage.THANK_YOU.getMessage());
				returnChange(cola.getItemPrice());
			}
		}
		else if(string == "CHIPS") {
			if(currentBalance.isLessThan(chips.getItemPrice())) {
				setDisplay("PRICE " + chips.getItemPrice());
			}
			else {
				setDisplay(DisplayMessage.THANK_YOU.getMessage());
				returnChange(chips.getItemPrice());
			}
		}
		else if(string == "CANDY") {
			if(currentBalance.isLessThan(candy.getItemPrice())) {
				setDisplay("PRICE " + candy.getItemPrice());
			}
			else {
				setDisplay(DisplayMessage.THANK_YOU.getMessage());
				returnChange(candy.getItemPrice());
			}
		}
		else if(string == "RETURN CHANGE") {
			returnChange(new DollarAmount(0));
		}
	}

	public void returnChange(DollarAmount purchasePrice) {
		currentBalance = currentBalance.minus(purchasePrice);
		while(currentBalance.isGreaterThanOrEqualTo(new DollarAmount(5))) {
			if(currentBalance.isGreaterThanOrEqualTo(new DollarAmount(25))) {
				currentBalance = currentBalance.minus(new DollarAmount(25));
				coinTray.add("quarter");
			}
			else if(currentBalance.isGreaterThanOrEqualTo(new DollarAmount(10))) {
				currentBalance = currentBalance.minus(new DollarAmount(10));
				coinTray.add("dime");
			}
			else if(currentBalance.isGreaterThanOrEqualTo(new DollarAmount(5))) {
				currentBalance = currentBalance.minus(new DollarAmount(5));
				coinTray.add("nickel");
			}
		}
		
		
	}
	
	

}
