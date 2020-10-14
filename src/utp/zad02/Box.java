package utp.zad02;

import java.util.ArrayList;

public class Box 
{
	static ArrayList<Kwiat> pudelko = null;
	public Box(Customer o)
	{
		pudelko = new ArrayList<Kwiat>();
	}
	
	public ArrayList<Kwiat> getBox()
	{
		return pudelko;
	}
	
	public String toString()
	{
		String wPudelku = "W pudelku: \n";
		for(int i = 0; i < pudelko.size(); i++)
		{
			wPudelku+=pudelko.get(i).toString();
		}
		return wPudelku;
	}
}
