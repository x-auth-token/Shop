package com.pa.common.branch;

import static com.pa.common.Validators.validateOnlyLettersUsed;

enum Clothes {
	JEANS, LONG_SLEEVE_SHIRT, SHORT_PANTS, SWEATER, TAILORED_PANTS, TSHIRT, COAT 
}

public class Stock {
	private int	   itemId;
	private String itemType;
	private String itemSize;
	private double itemPrice;
	private String itemVendor;
	private String colour;
	private int quantity;

	

	public Stock() {
		super();
	}

	public Stock(int id, String iType, String iSize, String colour, String iVendor, int Quantity) {
		setItemID();
		setItemType(iType);
		setItemSize(iSize);
		setColour(colour);
		setItemVendor(iVendor);
		setItemQuantity(Quantity);
	
		

	}

	private void setItemID() {
		// TODO Auto-generated method stub

	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) throws IllegalArgumentException {
		if (!validateOnlyLettersUsed(itemSize))
			throw new IllegalArgumentException(
					"Wrong input! itemSize should contain only letters like : small medium..");
		else {
			this.itemSize = itemSize;
		}
	}

	public String getItemVendor() {
		return itemVendor;
	}

	public void setItemVendor(String itemVendor) throws IllegalArgumentException {
		if (!validateOnlyLettersUsed(itemVendor))
			throw new IllegalArgumentException(
					"Wrong input! itemVendor should contain only letters like : adidas nike..");
		else {
			this.itemVendor = itemVendor;
		}
	}

	public int getItemQuantity() {
		return quantity;
	}

	public void setItemQuantity(int itemQuantity) {

		this.quantity = itemQuantity;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) throws IllegalArgumentException {

		if (!validateOnlyLettersUsed(colour))
			throw new IllegalArgumentException("Wrong input! colour should contain only letters like : blue");
		else
			colour = colour;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}
