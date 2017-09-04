package net.qcollins;

import java.util.ArrayList;

import net.qcollins.currency.Dime;
import net.qcollins.currency.Nickel;
import net.qcollins.currency.Quarter;


public class CoinBank {
	private ArrayList<Quarter> quarterStock;
	private ArrayList<Dime> dimeStock;
	private ArrayList<Nickel> nickelStock;
	
	public CoinBank() {
		quarterStock = new ArrayList<Quarter>();
		dimeStock = new ArrayList<Dime>();
		nickelStock = new ArrayList<Nickel>();
	}

	public ArrayList<Quarter> getQuarterStock() {
		return quarterStock;
	}
	
	public ArrayList<Dime> getDimeStock() {
		return dimeStock;
	}
	
	public ArrayList<Nickel> getNickelStock() {
		return nickelStock;
	}
}
