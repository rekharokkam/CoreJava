package com.book.tij.chapter6;

public class FinalMethodChild extends FinalMethodParent
{
	void spin()
	{
System.out.println("SPIN METHOD OF CHILD");		
		super.spin();
	}
//	void rotate(){} // cannot override as the method in the parent is final
	public static void main(String[] args) 
	{
		new FinalMethodChild().spin();
		new FinalMethodChild().rotate();
	}
}

class FinalMethodParent
{
	void spin()
	{
System.out.println("SPIN METHOD OF PARENT");		
	}
	
	final void rotate()
	{
System.out.println("ROtatE METHOD OF PARENT");		
	}
}


