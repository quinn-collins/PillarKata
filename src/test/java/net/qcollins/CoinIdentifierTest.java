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
}
