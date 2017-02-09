package com.vtc.java7.generics;

import java.util.ArrayList;
import java.util.List;

public class Subtyping
{
	public static void main(String[] args)
	{
		List<Number> numberList = new ArrayList<Number>();
		numberList.add(10);
		
		//Code below results in compile time error because in generics there is no default inheritance. A list of type "Number" accepts only "Numbers" not Integer or Decimal
//		numberList.add(new Integer());		
	}
}
