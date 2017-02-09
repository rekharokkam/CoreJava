package com.book.tij.chapter6;

public class BlankFinal 
{
	private final int i = 0; // initialization at the point of declaration
	private final int j;
	private final Poppet poppet;
	
	static
	{
		x = 10;
	}

	//Blank finals can be initialised in either of the ways - Constructor or blocks
	{
		j = 25;
		poppet = new Poppet(48);
	}
	
//	public BlankFinal ()
//	{
//		//initilize all the blank finals
//		j = 10;
//		poppet = new Poppet(100);		
//	}
	
	private static final int x; // this static final field needs to be initialised in the static block
}

class Poppet
{
	int i;
	Poppet(int i)
	{
		this.i = i;
	}
}