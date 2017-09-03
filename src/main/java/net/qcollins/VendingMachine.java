package net.qcollins;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	private CoinIdentifier coinIdentifier;
	private DollarAmount currentBalance = new DollarAmount(0);
	private List<String> coinTray;
	private String display;
	
	public List<String> getCoinTray() {
		return coinTray;
	}

	public VendingMachine(CoinIdentifier coinIdentifier) {
		this.coinIdentifier = coinIdentifier;
		coinTray = new ArrayList<String>();
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
			if(currentBalance.isLessThan(Product.COLA.getPrice())) {
				setDisplay("PRICE " + Product.COLA.getPrice());
			}
			else {
				setDisplay(DisplayMessage.THANK_YOU.getMessage());
				returnChange(Product.COLA.getPrice());
			}
		}
		else if(string == "CHIPS") {
			if(currentBalance.isLessThan(Product.CHIPS.getPrice())) {
				setDisplay("PRICE " + Product.CHIPS.getPrice());
			}
			else {
				setDisplay(DisplayMessage.THANK_YOU.getMessage());
				returnChange(Product.CHIPS.getPrice());
			}
		}
		else if(string == "CANDY") {
			if(currentBalance.isLessThan(Product.CANDY.getPrice())) {
				setDisplay("PRICE " + Product.CANDY.getPrice());
			}
			else {
				setDisplay(DisplayMessage.THANK_YOU.getMessage());
				returnChange(Product.CANDY.getPrice());
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
