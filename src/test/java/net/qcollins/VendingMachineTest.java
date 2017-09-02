package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class VendingMachineTest {
	VendingMachine vendingMachine;
	CoinIdentifier coinIdentifier;
	
	@Before
	public void setup() {
		coinIdentifier = new CoinIdentifier();
		vendingMachine = new VendingMachine(coinIdentifier);
	}
	
	@Test
	public void insertingQuarterAddsToCurrentAmount() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		Assert.assertEquals(0.25, vendingMachine.getCurrentBalance(),.001);
	}
}

