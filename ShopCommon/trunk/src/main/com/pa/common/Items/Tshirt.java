package com.pa.common.Items;

public class Tshirt extends Shirt 
{
	public Tshirt()
	{
		super();
	}

	public Tshirt(String iType,String iSize,String Colour,String iVendor,int Quantity,boolean Stock,int[] Branch)
	{
		setItemType(iType);
		setItemSize(iSize);
		setColour(Colour);
		setItemVendor(iVendor);
		setItemQuantity(Quantity);
		setInStock(Stock);
		setInBranch(Branch);
	}
}
