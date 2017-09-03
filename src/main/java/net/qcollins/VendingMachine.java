package net.qcollins;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	private CoinIdentifier coinIdentifier;
	private int currentBalance;
	private List<String> coinTray;
	
	public List<String> getCoinTray() {
		return coinTray;
	}

	public VendingMachine(CoinIdentifier coinIdentifier) {
		this.coinIdentifier = coinIdentifier;
		coinTray = new ArrayList<String>();
	}
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	
	public void insertCoin(double mass, double diameter, double thickness) {
		String coin = coinIdentifier.identify(mass, diameter, thickness);
		if(coin.equals("quarter")) {
			currentBalance += 25;
		}
		else if(coin.equals("dime")) {
			currentBalance += 10;
		}
		else if(coin.equals("nickel")) {
			currentBalance += 5;
		}
		else {
			coinTray.add(coin);
		}
		
	}

}
