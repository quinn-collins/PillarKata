package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoinIdentifierTest {
	private CoinIdentifier coinIdentifier;
	
	@Before
	public void setup() {
		coinIdentifier = new CoinIdentifier();
	}
	
	@Test
	public void identifierCorrectlyIdentifiesQuarter() {
		Assert.assertEquals("quarter", coinIdentifier.identify(5.670, 24.26, 1.75));
	}
	
	@Test
	public void identifierCorrectlyIdentifiesDime() {
		Assert.assertEquals("dime", coinIdentifier.identify(2.268, 17.91, 1.35));
	}
	
	@Test
	public void identifierCorrectlyIdentifiesNickel() {
		Assert.assertEquals("nickel", coinIdentifier.identify(5, 21.21, 1.95));
	}
	
	@Test
	public void identifierReturnsRejectedIfCriteriaNotMet() {
		Assert.assertEquals("rejected", coinIdentifier.identify(2.5, 19, 1.52));
	}
	
	@Test
	public void identifierIdentifiesQuartersThatHaveBeenWorn() {
		Assert.assertEquals("quarter", coinIdentifier.identify(5.570, 24.26, 1.75));
	}
}
