package com.vtc.java2certificate.chapter4;

import java.awt.Canvas;

public class InstanceOfExample
{
	public static void main(String[] args)
	{
		Canvas canvas = new Canvas ();
System.out.println("Checking to see if Canvas is an instance of parent Component Object : " + (canvas instanceof java.awt.Component));		
System.out.println("Checking to see if Canvas is an instance of Implementing interface ImageObserver: " + (canvas instanceof java.awt.image.ImageObserver));
System.out.println("Checking to see if Canvas is an instance of Canvas Object :) : " + (canvas instanceof java.awt.Canvas));
	}
}
