package net.qcollins;

public enum DisplayMessage {
	
	INSERT_COINS("INSERT COINS"),
	THANK_YOU("THANK YOU"),
	SOLD_OUT("SOLD OUT"),
	EXACT_CHANGE_ONLY("EXACT CHANGE ONLY"),
	ERROR("ERROR");
	
	private final String message;
	
	DisplayMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
