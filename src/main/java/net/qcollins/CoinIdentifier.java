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
		if(inRange(5.670, 0.1, mass)) {
			return "quarter";
		}
		else if(inRange(2.268, 0.1, mass)) {
			return "dime";
		}
		else if(mass == 5) {
			return "nickel";
		}
		else {
			return "rejected";
		}
	}
	
	private boolean inRange(double target, double range, double value) {
		return target - range <= value && target + range >= value;
	}

}
