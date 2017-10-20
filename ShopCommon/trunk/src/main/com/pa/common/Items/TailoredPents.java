package com.pa.common.Items;

public class TailoredPents extends Item 
{
	public TailoredPents()
	{
		super();
	}
	public TailoredPents(String iSize,String Colour,String iVendor,int Quantity,boolean Stock,int[] Branch)
	{
		setItemType("TailoredPents");
		setItemSize(iSize);
		setColour(Colour);
		setItemVendor(iVendor);
		setItemQuantity(Quantity);
		setInStock(Stock);
		setInBranch(Branch);
	}

}
