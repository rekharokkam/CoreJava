package com.book.tij.chapter6;

public class FinalArgument 
{

	void objWithFinalArgument (final Gizmo g)
	{
//		g = new Gizmo(); //not allowed
	}
	
	void primaryWithFinalArgument (final int i)
	{
		int j = 0;
//		j = i++; //not allowed
		j = i + 1; //allowed 
	}
}

class Gizmo
{
	Gizmo()
	{		
	}
	
	void spin(){}
}