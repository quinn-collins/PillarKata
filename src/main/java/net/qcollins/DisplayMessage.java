package net.qcollins;

public enum DisplayMessage {
	
	INSERT_COIN("INSERT COIN");
	
	private final String message;
	
	DisplayMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
