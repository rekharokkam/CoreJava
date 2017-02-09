package com.itreya.test2;

import javax.swing.*;

public class JpaneTest
{

	public static void main(String[] args)
	{
		
		if (args[0].equalsIgnoreCase("yes"))
		{
			int opinion = JOptionPane.showConfirmDialog(null,"one", "two", JOptionPane.OK_CANCEL_OPTION);
			if (opinion == 0)
			{
				System.out.println("THE USER'S CHOICE IS YES");
			}
			else
			{
				System.out.println("THE USER'S CHOICE IS NO");
			}
			
		}
	}
}
