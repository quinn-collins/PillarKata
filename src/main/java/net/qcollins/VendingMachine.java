package net.qcollins;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	private CoinIdentifier coinIdentifier;
	private DollarAmount currentBalance = new DollarAmount(0);
	private List<String> coinTray;
	
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
		}
		else if(coin.equals("dime")) {
			currentBalance = currentBalance.plus(new DollarAmount(10));
		}
		else if(coin.equals("nickel")) {
			currentBalance = currentBalance.plus(new DollarAmount(5));
		}
		else {
			coinTray.add(coin);
		}
		
	}

	public String getDisplay() {
		if(currentBalance.isGreaterThan(new DollarAmount(0))) {
			return currentBalance.toString();			
		}
		else {
			return DisplayMessage.INSERT_COINS.getMessage();
		}
	}

}
