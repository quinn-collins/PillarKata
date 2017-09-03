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
		if(currentBalance.compareTo(new DollarAmount(0))==0) {
			return DisplayMessage.INSERT_COINS.getMessage();
		}
		return display;
	}
	
	public void setDisplay(String display) {
		this.display = display;
	}

	public void pressButton(String string) {
		setDisplay(DisplayMessage.THANK_YOU.getMessage());
	}

	public void returnChange() {
		setDisplay(DisplayMessage.INSERT_COINS.getMessage());
		
	}

}
