package com.pa.common.branch;

import static com.pa.common.Validators.validateOnlyLettersUsed;
import static com.pa.common.Constants.*;


public class Stock {
	private Id itemId;
	private String itemType;
	private String itemSize;
	private double itemPrice;
	private String itemVendor;
	private String colour;
	private int quantity;

	

	public Stock() {
		super();
	}

	public Stock(Id id, String iType, String iSize, String colour, String iVendor, int Quantity) {
//		switch (id){
//		case JEANS: 
//			setItemType("Jeans"));
//			break;
//		case COAT:
//			break;
//		case LONG_SLEEVE_SHIRT:
//			break;
//		case SHORT_PANTS:
//			break;
//		case SWEATER:
//			break;
//		case TAILORED_PANTS:
//			break;
//		case TSHIRT:
//			break;
//		default:
//			break;
//		}
		setItemID(id);
		setItemType(iType);
		setItemSize(iSize);
		setColour(colour);
		setItemVendor(iVendor);
		setItemQuantity(Quantity);
	
		

	}

	private void setItemID(Id id) {
		// TODO Auto-generated method stub
		this.itemId = id;
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

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Id getItemId() {
		return itemId;
	}

	public void setItemId(Id itemId) {
		this.itemId = itemId;
	}

}
