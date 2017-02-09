package com.book.tij.chapter8;

public class NestingInterfaces 
{
	//Can have public class inside of a public class
	public class BImp implements A.B
	{
		public void f(){}
	}
	
	class CImp implements A.C
	{
		public void f(){}
	}

	//Cannot implement private interface
//	class DImp implements A.DImp
//	{
//		public void f(){}
//	}
	
	//Need not implement the methods of nested interfaces
	class EImp implements E
	{
		public void g(){}
	}
	
	class EGImp implements E.G
	{
		public void f(){}
	}
	
	class EImp2 implements E
	{
		public void g(){}
		
		public class EGImp2 implements E.G
		{
			public void f(){}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		A 
		a = new A(), a2 = new A();
		
		//Not possible as D is a private inner interface
//		A.D d = a.getD();
		
		/*
		 * Need to downcast to a specific class.
		 * Cannot Upcast to the interface as it is private inner interface
		 */
		A.DImp2 dImp2 = (A.DImp2)a.getD();
//		A.D dImp2 = a.getD();
		a2.receive(a.getD());
	}
}

class A
{
	//private interface
	private interface D
	{
		void f();
	}
	
	//public implementor of private interface
	public class DImp2 implements D
	{
		public void f(){}
	}
	
	//private implementor of private interface
	private class DImp implements D
	{
		public void f(){}
	}
	
	//package access Interface
	interface B
	{
		void f();
	}
	
	//public implementor of package access interface
	public class BIimp implements B
	{
		public void f(){}
	}
	
	//private implementor of package access interface
	private class BImp2 implements B
	{
		public void f(){}
	}

	//public Interface
	public interface C
	{
		void f();
	}
	
	//package access implementor of public interface
	class CImp implements C
	{
		public void f(){}
	}
	
	//private implementor of public interface
	private class CImp2 implements C
	{
		public void f(){}
	}
	
	private D ref;
	public D getD ()
	{
		return new DImp2 ();
	}
	
	public void receive (D d)
	{
		ref = d;
		ref.f();
	}
}

interface E
{
	/*
	 * Interface nested within another interface is strictly public.
	 * Cannot change the access specifier to lesser visiblity
	 * All the elements of an interface are strictly public.
	 */
	
	interface G
	{
		void f();
	}
	
	interface H
	{
		void f();
	}
	
	void g();
}

