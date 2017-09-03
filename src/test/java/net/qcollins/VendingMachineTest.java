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
		Assert.assertEquals(25, vendingMachine.getCurrentBalance(),.001);
	}
	
	@Test
	public void vendingMachineRejectsCoinsOfIncorrectDimensions() {
		vendingMachine.insertCoin(2.5, 19, 1.52);
		Assert.assertEquals(1, vendingMachine.getCoinTray().size());
	}
	
	@Test
	public void insertingDimeAddsToCurrentAmount() {
		vendingMachine.insertCoin(2.268, 17.91, 1.35);
		Assert.assertEquals(10, vendingMachine.getCurrentBalance(),.001);
	}
	
	@Test
	public void insertingNickelAddsToCurrentAmount() {
		vendingMachine.insertCoin(5, 21.21, 1.95);
		Assert.assertEquals(5, vendingMachine.getCurrentBalance(),.001);
	}
}

