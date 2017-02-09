package com.book.tij.chapter8;

import java.util.Random;

/*
 * Blank finals are not allowed in iterfaces.
 * They cannot be initialized in static initilizer block
 * But runtime expressions are allowed as shown
 */
public interface InterfaceBlankFinalInitialization 
{
//	int i;
//	static 
//	{
//		i = 100;
//	}
	//there can be runtime expressions assigned to interface field variables
	Random random = new Random();
	int i = random.nextInt(10);
	long l = random.nextLong() * 10;
}
