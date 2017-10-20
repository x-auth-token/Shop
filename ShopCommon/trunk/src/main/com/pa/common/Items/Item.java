package com.pa.common.Items;

import static com.pa.common.Validators.validateOnlyLettersUsed;

enum Clothes {JEANS,SHIRT}

public abstract class Item {
	private String itemType;
	private String itemSize;
	private String itemVendor;
	private String Colour;
	private int itemQuantity;
	private boolean inStock;
	private int[] inBranch;
	
	public Item (){
		super();
	}
	
	public Item(String iType,String iSize,String Colour,String iVendor,int Quantity,boolean Stock,int[] Branch)
	{
		setItemType(iType);
		setItemSize(iSize);
		setColour(Colour);
		setItemVendor(iVendor);
		setItemQuantity(Quantity);
		setInStock(Stock);
		setInBranch(Branch);
		
		
	}
	
	

	

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) throws IllegalArgumentException
	{
		if (!validateOnlyLettersUsed(itemSize))
			throw new IllegalArgumentException("Wrong input! itemSize should contain only letters like : small medium..");
	else {
		this.itemSize = itemSize;
	}
	}

	public String getItemVendor() {
		return itemVendor;
	}

	public void setItemVendor(String itemVendor) throws IllegalArgumentException
	{
		if (!validateOnlyLettersUsed(itemVendor))
			throw new IllegalArgumentException("Wrong input! itemVendor should contain only letters like : adidas nike..");
	else {
		this.itemVendor = itemVendor;
	}
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
	
		this.itemQuantity = itemQuantity;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public int[] getInBranch() {
		return inBranch;
	}

	public void setInBranch(int[] inBranch) {
		this.inBranch = inBranch;
	}

	public String getColour() {
		return Colour;
	}

	public void setColour(String colour) throws IllegalArgumentException {

		if (!validateOnlyLettersUsed(colour))
			throw new IllegalArgumentException("Wrong input! colour should contain only letters like : blue");
		else 
		Colour = colour;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	}

