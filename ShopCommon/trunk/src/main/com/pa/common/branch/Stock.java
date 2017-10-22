package com.pa.common.branch;


import static com.pa.common.Validators.validateOnlyLettersUsed;

import java.util.UUID;

import static com.pa.common.Constants.*;


public class Stock {
	private String id;
	private String type;
	private String size;
	private double price;
	private String vendor;
	private String colour;
	private int quantity;
	

	public Stock() {
		super();
	}

	public Stock(String iType, String iSize, String colour,String iVendor, int Quantity,double price) {

		this.id = UUID.randomUUID().toString();
		setType(iType);
		setSize(iSize);
		setColour(colour);
		setVendor(iVendor);
		setQuantity(Quantity);
		setPrice(price);
	
		

	}

//	private void setItemID(Id id) {
//		// TODO Auto-generated method stub
//		this.itemId = id;
//	}

	public String getSize() {
		return size;
	}

	public void setSize(String itemSize) throws IllegalArgumentException {
		if (!validateOnlyLettersUsed(itemSize))
			throw new IllegalArgumentException(
					"Wrong input! itemSize should contain only letters like : small medium..");
		else {
			this.size = itemSize;
		}
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String itemVendor) throws IllegalArgumentException {
		if (!validateOnlyLettersUsed(itemVendor))
			throw new IllegalArgumentException(
					"Wrong input! itemVendor should contain only letters like : adidas nike..");
		else {
			this.vendor = itemVendor;
		}
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int itemQuantity) {

		this.quantity = itemQuantity;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) throws IllegalArgumentException {

		if (!validateOnlyLettersUsed(colour))
			throw new IllegalArgumentException("Wrong input! colour should contain only letters like : blue");
		else
			this.colour = colour;
	}

	public final String getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	public void setType(String itemtType) {
		this.type = itemtType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double itemPrice) {
		this.price = itemPrice;
	}


	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		return "id: "+getId()+" itemSize: "+getSize()+" itemPrice:"+getPrice()+
				" itemVendor: "+getVendor()+" itemcolour:"+getColour()+" itemQuantity:"+getQuantity();
	}
	


}
