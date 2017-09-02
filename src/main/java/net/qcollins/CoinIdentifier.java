package net.qcollins;

public class CoinIdentifier {
	
	/**
	 * This method is used to identify coins based on some parameters.
	 * @param mass is identified in grams.
	 * @param diameter is identified in millimeters.
	 * @param thickness is identified in millimeters.
	 * @return a string with the name of the coin.
	 */
	public Object identify(double mass, double diameter, double thickness) {
		if(mass == 5.670) {
			return "quarter";
		}
		else if(mass == 2.268) {
			return "dime";
		}
		else if(mass == 5) {
			return "nickel";
		}
		else {
			return "rejected";
		}
	} 

}
