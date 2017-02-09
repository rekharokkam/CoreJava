package com.book.tij.chapter8;

public class InterfaceExtendingInterface 
{
	static void u(Monster monster)
	{
		monster.menace();
	}
	
	static void v(DangerousMonster dangerousMonster)
	{
		dangerousMonster.destroy();
	}
	
	static void w(Vampire vampire)
	{
		vampire.kill();
		vampire.drinkBlood();		
	}
	
	public static void main(String[] args) 
	{
		DangerousMonster gozilla = new DrangonZilla();
		u (gozilla);
		v (gozilla);
		
		Vampire vampire = new VeryBadVampire();
		w(vampire);
	}
}

interface Monster
{
	void menace();
}

interface DangerousMonster extends Monster
{
	void destroy();
}

interface Lethal
{
	void kill();
}

//interface extending interfaces
interface Vampire extends DangerousMonster, Lethal
{
	void drinkBlood();
}

class DrangonZilla implements DangerousMonster
{
	public void menace(){}
	public void destroy(){}
}

class VeryBadVampire implements Vampire
{
	public void menace(){}
	public void destroy(){}
	public void kill(){}
	public void drinkBlood(){}
}
