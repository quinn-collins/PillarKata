package net.qcollins;

import org.junit.Before;

public class VendingMachineTest {
	VendingMachine vendingMachine;
	CoinIdentifier coinIdentifier;
	
	@Before
	public void setup() {
		coinIdentifier = new CoinIdentifier();
		vendingMachine = new VendingMachine(coinIdentifier);
	}
}

