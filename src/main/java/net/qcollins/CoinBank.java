package net.qcollins;

import java.util.ArrayList;



import net.qcollins.currency.Quarter;


public class CoinBank {
	private ArrayList<Quarter> quarterStock;
	
	public CoinBank() {
		quarterStock = new ArrayList<Quarter>();
	}

	public ArrayList<Quarter> getQuarterStock() {
		return quarterStock;
	}
}
