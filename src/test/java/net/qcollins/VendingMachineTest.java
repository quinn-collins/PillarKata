package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.qcollins.product.VendingMachineItem;



public class VendingMachineTest {
	VendingMachine vendingMachine;
	CoinIdentifier coinIdentifier;
	Inventory inventory;
	VendingMachineItem cola;
	VendingMachineItem chips;
	VendingMachineItem candy;
	
	@Before
	public void setup() {
		coinIdentifier = new CoinIdentifier();
		inventory = new Inventory();
		vendingMachine = new VendingMachine(coinIdentifier, inventory);
		
	}
	
	@Test
	public void insertingQuarterAddsToCurrentAmount() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		Assert.assertEquals(new DollarAmount(25), vendingMachine.getCurrentBalance());
	}
	
	@Test
	public void vendingMachineRejectsCoinsOfIncorrectDimensions() {
		vendingMachine.insertCoin(2.5, 19, 1.52);
		Assert.assertEquals(1, vendingMachine.getCoinTray().size());
	}
	
	@Test
	public void insertingDimeAddsToCurrentAmount() {
		vendingMachine.insertCoin(2.268, 17.91, 1.35);
		Assert.assertEquals(new DollarAmount(10), vendingMachine.getCurrentBalance());
	}
	
	@Test
	public void insertingNickelAddsToCurrentAmount() {
		vendingMachine.insertCoin(5, 21.21, 1.95);
		Assert.assertEquals(new DollarAmount(5), vendingMachine.getCurrentBalance());
	}
	
	@Test
	public void insertingNickelShowsCorrectlyOnDisplay() {
		vendingMachine.insertCoin(5, 21.21, 1.95);
		Assert.assertEquals("$0.05", vendingMachine.getDisplay());
	}
	
	@Test
	public void insertingQuarterShowsCorrectlyOnDisplay() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		Assert.assertEquals("$0.25", vendingMachine.getDisplay());
	}
	
	@Test
	public void whenNoCoinsAreInsertedMachineDisplaysInsertCoins() {
		Assert.assertEquals("INSERT COINS", vendingMachine.getDisplayAgain());
	}
	
	@Test
	public void whenColaButtonPressedAndMachineHasBeenFedEnoughMoneyDisplayShowsThankYou() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("COLA");
		Assert.assertEquals("THANK YOU", vendingMachine.getDisplay());
	}
	
	@Test
	public void afterColaButtonPressedAndItemHasBeenDispensedMachineDisplaysInsertCoins() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("COLA");
		
		Assert.assertEquals("INSERT COINS", vendingMachine.getDisplayAgain());
	}
	
	@Test
	public void whenTheAmountOfMoneyInsertedIsNotEnoughForTheItemMachineDisplaysPrice() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("COLA");
		Assert.assertEquals("PRICE $1.00", vendingMachine.getDisplay());
	}
	
	@Test
	public void whenTheAmountOfMoneyInsertedIsNotEnoughForColaMachineDisplaysCurrentBalance() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("COLA");
		Assert.assertEquals(vendingMachine.getCurrentBalance().toString(), vendingMachine.getDisplayAgain());
	}
	
	@Test
	public void whenTheAmountOfMoneyInsertedIsNotEnoughForChipsMachineDisplaysCurrentBalance() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CHIPS");
		Assert.assertEquals(vendingMachine.getCurrentBalance().toString(), vendingMachine.getDisplayAgain());
	}
	
	@Test
	public void whenTheAmountOfMoneyInsertedIsNotEnoughCandyItemMachineDisplaysCurrentBalance() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CANDY");
		Assert.assertEquals(vendingMachine.getCurrentBalance().toString(), vendingMachine.getDisplayAgain());
	}
	
	@Test
	public void whenChipButtonPressedAndMachineHasBeenFedEnoughMoneyDisplayShowsThankYou() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CHIPS");
		Assert.assertEquals("THANK YOU", vendingMachine.getDisplay());
	}
	
	@Test
	public void afterChipButtonPressedAndItemHasBeenDispensedMachineDisplaysInsertCoins() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CHIPS");
		Assert.assertEquals("INSERT COINS", vendingMachine.getDisplayAgain());
	}
	
	@Test
	public void whenCandyButtonPressedAndMachineHasBeenFedEnoughMoneyDisplayShowsThankYou() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CANDY");
		Assert.assertEquals("THANK YOU", vendingMachine.getDisplay());
	}
	
	@Test
	public void afterCandyButtonPressedAndItemHasBeenDispensedMachineDisplaysInsertCoins() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CANDY");
		Assert.assertEquals("INSERT COINS", vendingMachine.getDisplayAgain());
	}
	
	@Test
	public void afterPurchaseHasBeenMadeCurrentBalanceIsSetToZero() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CHIPS");
		Assert.assertEquals(new DollarAmount(0), vendingMachine.getCurrentBalance());
	}
	
	@Test
	public void whenPurchaseIsMadeWithExtraMoneyInMachineTheExtraIsPutInTheCoinTray() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CHIPS");
		Assert.assertEquals(2, vendingMachine.getCoinTray().size());
	}
	
	@Test
	public void whenCustomerPressesReturnChangeButtonCoinsAreAddedToCoinTray() {
		vendingMachine.insertCoin(2.268, 17.91, 1.35);
		vendingMachine.insertCoin(2.268, 17.91, 1.35);
		vendingMachine.insertCoin(2.268, 17.91, 1.35);
		vendingMachine.pressButton("RETURN CHANGE");
		Assert.assertEquals(2, vendingMachine.getCoinTray().size());
	}
	
	
	
	@Test
	public void canSetInventory() {
		inventory.getItemStock().put(cola, 30);
		Assert.assertEquals(30, inventory.getItemStock().get(cola).intValue());
	}
	
	@Test
	public void whenChipsAreOutOfStockTheMachineDisplaysSoldOut() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CHIPS");
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CHIPS");
		Assert.assertEquals("SOLD OUT", vendingMachine.getDisplay());
	}
	
	@Test
	public void whenColaIsOutOfStockTheMachineDisplaysSoldOut() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("COLA");
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("COLA");
		Assert.assertEquals("SOLD OUT", vendingMachine.getDisplay());
	}
	
	@Test
	public void whenCandyIsOutOfStockTheMachineDisplaysSoldOut() {
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CANDY");
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.insertCoin(5.670, 24.26, 1.75);
		vendingMachine.pressButton("CANDY");
		Assert.assertEquals("SOLD OUT", vendingMachine.getDisplay());
	}
}

