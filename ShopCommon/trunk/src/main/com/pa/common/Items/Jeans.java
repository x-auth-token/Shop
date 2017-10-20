package com.pa.common.Items;

public class Jeans extends Item {
	
	public Jeans()
	{
		super();
	}
	
	public Jeans(String iSize,String Colour,String iVendor,int Quantity,boolean Stock,int[] Branch)
	{
		setItemType("Jeans");
		setItemSize(iSize);
		setColour(Colour);
		setItemVendor(iVendor);
		setItemQuantity(Quantity);
		setInStock(Stock);
		setInBranch(Branch);
	}
	

}
