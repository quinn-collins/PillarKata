package net.qcollins;

import java.util.ArrayList;
import java.util.List;

import net.qcollins.currency.Currency;
import net.qcollins.currency.Dime;
import net.qcollins.currency.Nickel;
import net.qcollins.currency.Quarter;
import net.qcollins.product.Candy;
import net.qcollins.product.Chips;
import net.qcollins.product.Cola;
import net.qcollins.product.VendingMachineItem;

public class VendingMachine {
	private CoinIdentifier coinIdentifier;
	private DollarAmount currentBalance = new DollarAmount(0);
	private List<Currency> coinTray;
	private String display;
	private Inventory inventory;
	private CoinBank coinBank;
	private VendingMachineItem cola;
	private VendingMachineItem chips;
	private VendingMachineItem candy;
	
	
	
	public List<Currency> getCoinTray() {
		return coinTray;
	}

	public VendingMachine(CoinIdentifier coinIdentifier, Inventory inventory, CoinBank coinBank) {
		this.coinIdentifier = coinIdentifier;
		this.inventory = inventory;
		this.coinBank = coinBank;
		coinTray = new ArrayList<Currency>();
		cola = new Cola("Cola", new DollarAmount(100));
		chips = new Chips("Chips", new DollarAmount(50));
		candy = new Candy("Candy", new DollarAmount(65));
		
	}
	
	public void replenishInventory(int numberOfColas, int numberOfChips, int numberOfCandy) {
		inventory.getItemStock().put(cola, numberOfColas);
		inventory.getItemStock().put(chips, numberOfChips);
		inventory.getItemStock().put(candy, numberOfCandy);
	}
	
	public void replenishCoinsInCoinBank(int numberOfQuartersToBeAdded, int numberOfDimesToBeAdded, int numberOfNickelsToBeAdded) {
		for(int i = 0; i < numberOfQuartersToBeAdded; i++) {
			coinBank.getQuarterStock().add(new Quarter(new DollarAmount(25), "quarter"));
		}
		for(int i = 0; i < numberOfDimesToBeAdded; i++) {
			coinBank.getDimeStock().add(new Dime(new DollarAmount(10), "dime"));
		}
		for(int i = 0; i < numberOfNickelsToBeAdded; i++) {
			coinBank.getNickelStock().add(new Nickel(new DollarAmount(5), "nickel"));
		}
	}
	
	public DollarAmount getCurrentBalance() {
		return currentBalance;
	}
	
	public void insertCoin(double mass, double diameter, double thickness) {
		Currency coin = coinIdentifier.identify(mass, diameter, thickness);
		if(coin.getValue().isGreaterThan(new DollarAmount(1))) {
			if(coin.getName().equals("quarter")) {
				coinBank.getQuarterStock().add((Quarter) coin);
			}
			if(coin.getName().equals("dime")) {
				coinBank.getDimeStock().add((Dime) coin);
			}
			if(coin.getName().equals("nickel")) {
				coinBank.getNickelStock().add((Nickel) coin);
			}
			currentBalance = currentBalance.plus(coin.getValue());
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
			productPurchase(cola);
		}
		else if(string == "CHIPS") {
			productPurchase(chips);
		}
		else if(string == "CANDY") {
			productPurchase(candy);
		}
		else if(string == "RETURN CHANGE") {
			returnChange(new DollarAmount(0));
		}
		else {
			setDisplay(DisplayMessage.ERROR.getMessage());
		}
	}
	
	public void productPurchase(VendingMachineItem item) {
		
		if(currentBalance.isLessThan(item.getItemPrice())) {
			setDisplay("PRICE " + item.getItemPrice());
		}
		else if(inventory.getItemStock().get(item) < 1) {
			setDisplay(DisplayMessage.SOLD_OUT.getMessage());
		}
		else {
			setDisplay(DisplayMessage.THANK_YOU.getMessage());
			inventory.decreaseItemStock(item);
			returnChange(item.getItemPrice());
		}
	}
	

	public void returnChange(DollarAmount purchasePrice) {
		currentBalance = currentBalance.minus(purchasePrice);
		while(currentBalance.isGreaterThanOrEqualTo(new DollarAmount(5))) {
			if(currentBalance.isGreaterThanOrEqualTo(new DollarAmount(25))) {
				currentBalance = currentBalance.minus(new DollarAmount(25));
				coinTray.add(new Quarter(new DollarAmount(25), "quarter"));
			}
			else if(currentBalance.isGreaterThanOrEqualTo(new DollarAmount(10))) {
				currentBalance = currentBalance.minus(new DollarAmount(10));
				coinTray.add(new Dime(new DollarAmount(10), "dime"));
			}
			else if(currentBalance.isGreaterThanOrEqualTo(new DollarAmount(5))) {
				currentBalance = currentBalance.minus(new DollarAmount(5));
				coinTray.add(new Nickel(new DollarAmount(25), "nickel"));
			}
		}
	}
	
	

}
