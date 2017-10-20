package com.pa.common.Items;

public class Coat extends Shirt{
	public Coat()
	{
		super();
	}
	public Coat(String iSize,String Colour,String iVendor,int Quantity,boolean Stock,int[] Branch)
	{
		setItemType("Coat");
		setItemSize(iSize);
		setColour(Colour);
		setItemVendor(iVendor);
		setItemQuantity(Quantity);
		setInStock(Stock);
		setInBranch(Branch);
		
		
	}

}
