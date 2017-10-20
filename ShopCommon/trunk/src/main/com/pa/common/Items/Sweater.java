package com.pa.common.Items;

public class Sweater extends Shirt 
{
	public Sweater()
	{
		super();
	}
	public Sweater(String iSize,String Colour,String iVendor,int Quantity,boolean Stock,int[] Branch)
	{
		setItemType("Sweater");
		setItemSize(iSize);
		setColour(Colour);
		setItemVendor(iVendor);
		setItemQuantity(Quantity);
		setInStock(Stock);
		setInBranch(Branch);
		
		
	}

}
