package com.book.tij.chapter8;

public class MethodScopeInnerClass
{
	Destinations getDestination(String label)
	{
		//Method Scope Inner class
		class PDestination implements Destinations //Class definition starts here
		{
			//Cannot have static variables in non-static
//			static Name name = new Name ("StatIC METHOD INNER CLASS VARIABLE");
			Name name1 = new Name ("NON-StatIC METHOD INNER CLASS VARIABLE");
			private String destinationName;
			PDestination(String destinationName)
			{
				this.destinationName = destinationName;
			}
			
			public String readLabel ()
			{
				return destinationName;
			}
		} // Class definition ends here
		
		return new PDestination (label);//Creating a new Object	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		new MethodScopeInnerClass().getDestination("Home");
System.out.println("LABEL :: " + new MethodScopeInnerClass().
		getDestination("Home").readLabel());		
	}

}

interface Destinations
{
	String readLabel();
}