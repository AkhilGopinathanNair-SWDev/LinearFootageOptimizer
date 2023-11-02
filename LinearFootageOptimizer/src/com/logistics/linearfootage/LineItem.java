package com.logistics.linearfootage;

public class LineItem {
	
	int lengthInches;
	int widthInches;
	int heightInches;
	int weightLbs;
	boolean stackable;
	boolean turnable;
	
	public LineItem(int lengthInches, int widthInches, int heightInches, int weightLbs, boolean stackable, boolean turnable) 
	{
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
        this.heightInches = heightInches;
        this.weightLbs = weightLbs;
        this.stackable = stackable;
        this.turnable = turnable;
    }
	
}
