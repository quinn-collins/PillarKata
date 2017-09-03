package net.qcollins;

public enum DisplayMessage {
	
	INSERT_COINS("INSERT COINS"),
	THANK_YOU("THANK YOU");
	
	private final String message;
	
	DisplayMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
