package net.qcollins;

public enum Product {
	
	COLA(new DollarAmount(100)),
	CHIPS(new DollarAmount(50)),
	CANDY(new DollarAmount(65));
	
	private final DollarAmount productPrice;
	
	Product(final DollarAmount productPrice) {
        this.productPrice = productPrice;
    }

	public DollarAmount getPrice() {
		return productPrice;
	}
	
}
