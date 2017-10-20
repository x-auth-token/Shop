package com.pa.common.Items;

public class Tshirt extends Shirt 
{
	public Tshirt()
	{
		super();
	}

	public Tshirt(String iSize,String Colour,String iVendor,int Quantity,boolean Stock,int[] Branch)
	{
		setItemType("Tshirt");
		setItemSize(iSize);
		setColour(Colour);
		setItemVendor(iVendor);
		setItemQuantity(Quantity);
		setInStock(Stock);
		setInBranch(Branch);
	}
}
