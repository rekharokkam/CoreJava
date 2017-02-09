package com.vtc.java6.chapter4_temp;

public class ParametricBinding
{
	
	private class Stash <Number>
	{
		private Number name;
		
		public Number getName ()
		{
			return name;
		}
		
		public void setName (Number name)
		{
			this.name = name;
		}
	}
	
	
	public static void main(String[] args)
	{
		ParametricBinding test = new ParametricBinding();
		ParametricBinding.Stash<Integer> stash = test.new Stash<Integer>();
		stash.setName(new Integer(10));
		ParametricBinding.Stash<Object> stash1 = test.new Stash<Object>();
	}
}
