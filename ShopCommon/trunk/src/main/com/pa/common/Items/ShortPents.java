package com.pa.common.Items;

public class ShortPents extends Pents 
{
	public ShortPents()
	{
		super();
		
	}

	public ShortPents(String iSize,String Colour,String iVendor,int Quantity,boolean Stock,int[] Branch)
	{
		setItemType("ShortPents");
		setItemSize(iSize);
		setColour(Colour);
		setItemVendor(iVendor);
		setItemQuantity(Quantity);
		setInStock(Stock);
		setInBranch(Branch);
	}
	
	
}
