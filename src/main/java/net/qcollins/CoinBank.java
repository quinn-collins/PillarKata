package net.qcollins;

import java.util.ArrayList;

import net.qcollins.currency.Dime;
import net.qcollins.currency.Quarter;


public class CoinBank {
	private ArrayList<Quarter> quarterStock;
	private ArrayList<Dime> dimeStock;
	
	public CoinBank() {
		quarterStock = new ArrayList<Quarter>();
		dimeStock = new ArrayList<Dime>();
	}

	public ArrayList<Quarter> getQuarterStock() {
		return quarterStock;
	}
	
	public ArrayList<Dime> getDimeStock() {
		return dimeStock;
	}
}
