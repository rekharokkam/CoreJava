package com.book.tij.chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassObjectCreation
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{	
		/*
		 * Two ways of creating Class object.
		 * Class literal is a preferred choice because its checked at compile time, simpler, safer
		 * 
		 */
//System.out.println(new Candy().getClass().getName());//through new Object creation
//System.out.println(Gum.class.getName());//through class literal

		
		/*
		 * Class object can be created for all types - regular classes, arrays, interfaces, primitivetypes and Void 
		 */
//System.out.println("Regularclass Object : " + new Candy().getClass().getName());//Regularclass object
//System.out.println("Interfaces : " + Comparator.class.getName());//Interface
//System.out.println("Arrays : " + (new String[]{}).getClass().getName());//Arrays
//System.out.println("Primitive : " + boolean.class.getName());//Primitivetype
//System.out.println("Void : " + void.class.getName());//Void				
	
		/*
		 * Field "TYPE" of all the primitive wrapper classes represents the class object of associated primitive classes.
		 */
//System.out.println(Boolean.TYPE.getName());//boolean.class
//System.out.println(Character.TYPE.getName());//char.class
//System.out.println(Byte.TYPE.getName());//byte.class
//System.out.println(Short.TYPE.getName());//short.class
//System.out.println(Integer.TYPE.getName());//int.class
//System.out.println(Long.TYPE.getName());//long.class
//System.out.println(Float.TYPE.getName());//float.class
//System.out.println(Double.TYPE.getName());//double.class
//System.out.println(Void.TYPE.getName());//void.class

		List one = new ArrayList();
		one.add("1");
		one.add("4");
		one.add("3");
		Collections.sort(one);
		
		List two = new ArrayList();
		two.add("1");
		two.add("3");
		two.add("4");
		Collections.sort(two);
		
System.out.println("the difference : " + one.equals(two));		
	}

}
