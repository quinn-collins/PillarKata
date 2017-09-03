package net.qcollins;

public enum Product {
	
	COLA(100),
	CHIPS(50),
	CANDY(65);
	
	private final int productPrice;
	
	Product(final int productPrice) {
        this.productPrice = productPrice;
    }

	public int getPrice() {
		return productPrice;
	}
	
}
